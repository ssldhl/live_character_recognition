import ij.IJ;
import ij.ImagePlus;
import ij.plugin.ImageCalculator;
import ij.process.ImageProcessor;

public class featureMapGen
{
	public ImagePlus featureMapGen(ImagePlus[][] newpyramid,int width,int height)
	{
		ImageCalculator ic = new ImageCalculator();
		ImagePlus I=IJ.createImage("new_image", "8-bit black", width, height, 1); // creating 8-bit image
		ImagePlus I1=IJ.createImage("new_image", "8-bit black", width, height, 1);
		ImagePlus featuremap=IJ.createImage("new_image", "8-bit black", width, height, 1);
		ImagePlus temp=IJ.createImage("new_image", "8-bit black", width, height, 1);
		
		int[][] w= new int[width][height];
		
		
		ImageProcessor ip1=temp.getProcessor();
		for(int s=0;s<2;s++)
		{
			for(int deg=0;deg<4;deg++)
			{
				ImageProcessor ip=newpyramid[s][deg].getProcessor();
				ImagePlus temp1=newpyramid[s][deg].duplicate();
				IJ.run(temp1, "Find Edges", "");				
				ImageProcessor ip2=temp1.getProcessor();
				w=window(ip2,width,height);
				for(int x=-3;x<=3;x++)
				{
					for(int y=-3;y<=3;y++)
					{
						for(int i=0;i<height;i++)
						{
							for(int j=0;j<width;j++)
							{
								ip1.putPixel(j,i,ip.getPixel(j+y,i+x)*w[j][i]);
							}
						}
						I=ic.run("Add create", I, temp);
					}
				}
				I1=ic.run("Add create", I1, I);
				IJ.run(I1, "Enhance Contrast...", "saturated=0.4 normalize");
			}
			featuremap=ic.run("Add create", featuremap, I1);
		}
		I.flush();
		I1.flush();
		temp.flush();
		return featuremap;
	}
	
	private	int[][] window(ImageProcessor ip,int wi, int he)
	{
			int[][] w=new int[wi][he];
			int[] a=new int[4];
			for(int l=0;l<4;l++)
			{
				a[l]=0;
			}
			
			for(int i=0;i<he;i++)
			{
				for(int j=0;j<wi;j++)
				{
					w[j][i]=0;
					for(int l=0;l<4;l++)
					{
						a[l]=0;
					}
					// check white pixels only
					if(ip.getPixel(j,i)==255)
					{
						if((ip.getPixel(j-1,i)==255)&&(ip.getPixel(j+1,i)==255))
						{
							a[0]=1;
						}
						if((ip.getPixel(j,i-1)==255)&&(ip.getPixel(j,i+1)==255))
						{
							a[1]=1;
						}
						if((ip.getPixel(j+1,i-1)==255)&&(ip.getPixel(j-1,i+1)==255))
						{
							a[2]=1;
						}
						if((ip.getPixel(j-1,i-1)==255)&&(ip.getPixel(j+1,i+1)==255))
						{
							a[3]=1;
						}
					}
					for(int k=0;k<4;k++)
					{
						w[j][i]=a[k]+w[j][i];
					}
				}
			}
			return(w);
	}
}