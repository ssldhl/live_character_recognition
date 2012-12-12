import ij.IJ;
import ij.ImagePlus;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class characExtract
{
        Lcr lcr = new Lcr(); 
        java.io.File file = new java.io.File("").getAbsoluteFile();
        String name = file.getPath().replace('\\','/')+'/';
	        
	private int count=0;
        private int sp=0;
        int space[];
        int y=0;
        
        public void spaceset(int a){
            space= new int[a];
        }
	
	public int[] characExtract(int l)
	{
		Scanner s = null;
		
		int bx[] = new int[999];
		int by[] = new int[999];
		int wid[] = new int[999];
		int hei[] = new int[999];
		
		int i=0;
                int z=0;
		int tempy=0;
		int tempx=0;
		int tempwid=0;
		int temphei=0;
		int t=0;
	
		ImagePlus last = IJ.openImage(name+"src/cache/output/"+(count+1)+".jpg");
		IJ.run(last,"Make Binary","");
		IJ.run(last, "Skeletonize", "");		
		
		IJ.run(last, "Analyze Particles...", "size=0-Infinity circularity=0.00-1.00 show=Nothing exclude");
		IJ.saveAs("Results", name+"src/cache/sResults.txt");

		try {
			s = new Scanner(new BufferedReader(new FileReader(name+"src/cache/sResults.txt")));
			s.useLocale(Locale.US);
			while (s.hasNext()) {
				if (s.hasNextInt()) {
					s.nextInt(); // sno. not required
					s.nextInt();
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
				t=j+1;
				while(t<i)
				{
					if(by[j]==by[t])
					{
						if(bx[j]>bx[t])
						{
							tempy=by[j];
							by[j]=by[t];
							by[t]=tempy;
							
							tempx=bx[j];
							bx[j]=bx[t];
							bx[t]=tempx;
							
							tempwid=wid[j];
							wid[j]=wid[t];
							wid[t]=tempwid;
							
							temphei=hei[j];
							hei[j]=hei[t];
							hei[t]=temphei;
						}
					}
					else if((by[j]+hei[j])>(by[t]+hei[t]))
					{
						tempy=by[j];
						by[j]=by[t];
						by[t]=tempy;
							
						tempx=bx[j];
						bx[j]=bx[t];
						bx[t]=tempx;
							
						tempwid=wid[j];
						wid[j]=wid[t];
						wid[t]=tempwid;
							
						temphei=hei[j];
						hei[j]=hei[t];
						hei[t]=temphei;
					}
					for(int c=-10;c<=10;c++)
					{
						int a=by[j]+hei[j]+c;
						if(a==(by[t]+hei[t]))
						{
							if(bx[j]>bx[t])
							{
								
								tempy=by[j];
								by[j]=by[t];
								by[t]=tempy;
							
								tempx=bx[j];
								bx[j]=bx[t];
								bx[t]=tempx;
							
								tempwid=wid[j];
								wid[j]=wid[t];
								wid[t]=tempwid;
							
								temphei=hei[j];
								hei[j]=hei[t];
								hei[t]=temphei;
							}
						}
					}
					t++;
				}
			}
		
		for(int j=0;j<i;j++)
		{
			if(wid[j]<3||hei[j]<5)
			{
				continue;
			}
			else
			{
				ImagePlus I2=last.duplicate();
				I2.setRoi(bx[j],by[j],wid[j],hei[j]);
				IJ.run(I2, "Crop", "");
		
				IJ.run(I2, "Size...", "width=5 height=7 average interpolation=Bilinear");
				IJ.run(I2,"Make Binary","");
				IJ.run(I2, "Save", "save="+name+"src/cache/ocr/"+(y+1)+".jpg");
				z++;
                                y++;
				I2.flush();
			}
		}
                space[sp]=z;
                sp++;
		last.flush();
		IJ.run("Clear Results", "");
		
		//File file1 = new File(name+"src/cache/output/"+(count+1)+".jpg");
		//file1.delete();
                
		
		count++;
		
		if(count<l){
			characExtract(l);
		}
                File file2 = new File(name+"src/cache/sResults.txt");
		file2.delete();
		return (space);
	}
}