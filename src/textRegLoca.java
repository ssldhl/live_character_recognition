import ij.IJ;
import ij.ImagePlus;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class textRegLoca
{
	private int l=0;
        java.io.File file = new java.io.File("").getAbsoluteFile();
        String name = file.getPath().replace('\\','/')+'/';
	
	public int textRegLoca(ImagePlus featuremap, ImagePlus finish)
	{
		IJ.setAutoThreshold(featuremap, "Otsu dark"); // Otsu threshold
		IJ.run(featuremap,"Make Binary","");
		
		IJ.run(featuremap, "Dilate", "");
		
		IJ.run("Set Measurements...", "area bounding redirect=None decimal=3");
		IJ.run(featuremap, "Analyze Particles...", "size=0-Infinity circularity=0.00-1.00 show=Nothing exclude");
		IJ.saveAs("Results", name+"src/cache/Results.txt");

		Scanner s = null;
		float area[] = new float[9999];
		int bx[] = new int[9999];
		int by[] = new int[9999];
		int wid[] = new int[9999];
		int hei[] = new int[9999];
			
		int i=0;
		float max=area[0];
		float sum=0;
			
		float tempa=0;
		int tempy=0;
		int tempx=0;
		int tempwid=0;
		int temphei=0;
		int k=0;
			
		try {
			s = new Scanner(new BufferedReader(new FileReader(name+"src/cache/Results.txt")));
			s.useLocale(Locale.US);
			
			while (s.hasNext()) {
				if (s.hasNextInt()) {
					s.nextInt(); // serial no. not required
					area[i] = s.nextInt();//calculation of area
					bx[i] = s.nextInt();
					by[i] = s.nextInt();
					wid[i] = s.nextInt();
					hei[i] = s.nextInt();
					i++;
				} else {
					s.next();
				}   
			}
		}catch(IOException e){
			e.printStackTrace();}
				
		s.close();
			
		//arrange words as in text books
						
		for(int j=0;j<i;j++)
		{
			k=j+1;
			while(k<i)
			{
				if(by[j]==by[k])
				{
					if(bx[j]>bx[k])
					{
						tempa=area[j];
						area[j]=area[k];
						area[k]=tempa;
						
						tempy=by[j];
						by[j]=by[k];
						by[k]=tempy;
							
						tempx=bx[j];
						bx[j]=bx[k];
						bx[k]=tempx;
							
						tempwid=wid[j];
						wid[j]=wid[k];
						wid[k]=tempwid;
							
						temphei=hei[j];
						hei[j]=hei[k];
						hei[k]=temphei;
					}
				}
				else if((by[j]+hei[j])>(by[k]+hei[k]))
				{
					tempa=area[j];
					area[j]=area[k];
					area[k]=tempa;
							
					tempy=by[j];
					by[j]=by[k];
					by[k]=tempy;
							
					tempx=bx[j];
					bx[j]=bx[k];
					bx[k]=tempx;
							
					tempwid=wid[j];
					wid[j]=wid[k];
					wid[k]=tempwid;
							
					temphei=hei[j];
					hei[j]=hei[k];
					hei[k]=temphei;
				}
				for(int c=-10;c<=10;c++)
				{
					int a=by[j]+hei[j]+c;
					if(a==(by[k]+hei[k]))
					{
						if(bx[j]>bx[k])
						{
							tempa=area[j];
							area[j]=area[k];
							area[k]=tempa;
							
							tempy=by[j];
							by[j]=by[k];
							by[k]=tempy;
							
							tempx=bx[j];
							bx[j]=bx[k];
							bx[k]=tempx;
							
							tempwid=wid[j];
							wid[j]=wid[k];
							wid[k]=tempwid;
							
							temphei=hei[j];
							hei[j]=hei[k];
							hei[k]=temphei;
						}
					}
				}
				k++;
			}
		}
		
		for(int a=1;a<i;a++)
		{
			if(max<area[a])
			{
				max=area[a];
			}
		}
			
		for(int a=0;a<i;a++)
		{
			sum = sum+area[a];
		}
			
		for(int a=0;a<i;a++)
		{
			if(area[a]<=max/20)
			{
				continue;
			}
			else if((float)wid[a]/hei[a]<=0.2)
			{
				continue;
			}
			else if(area[a]>(sum-area[a]))
			{
				continue;
			}
			else
			{
				ImagePlus I2=finish.duplicate();
				I2.setRoi(bx[a],by[a],wid[a],hei[a]);
				IJ.run(I2, "Crop", "");
				IJ.run(I2,"Make Binary","");
				IJ.run(I2, "Save", "save="+name+"src/cache/output/"+(l+1)+".jpg");
				l++;
				I2.flush();
			}
		}

		IJ.run("Clear Results", "");
		File file1 = new File(name+"src/cache/Results.txt");
		file1.delete();
                
		finish.flush();
		
		return l;
	}
}