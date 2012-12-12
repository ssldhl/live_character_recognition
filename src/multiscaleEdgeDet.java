import ij.IJ;
import ij.ImagePlus;

public class multiscaleEdgeDet
{
	public ImagePlus[][] multiscaleEdgeDet(ImagePlus im, int height, int width)
	{
		ImagePlus[] pyramid = new ImagePlus[4];

		for(int i=0;i<2;i++)
		{
			IJ.run(im, "Gaussian Blur...", "sigma=0.5");// Applies Gaussian Blur with sigma=0.5
			pyramid[i]=im.duplicate();
			IJ.run(im, "Scale...", "x=0.5 y=0.5");// Downsample by 1/2
		}
		im.flush();
		
		ImagePlus[][] newpyramid = new ImagePlus[2][4];
		
		// Copying Images in pyramid to process
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<4;j++)
			{
				newpyramid[i][j]=pyramid[i].duplicate();
			}
			pyramid[i].flush();
		}
		// Convolving images at each level in the Pyramid with each direction filter
		for(int i=0;i<2;i++)
		{
			int j=0;
			IJ.run(newpyramid[i][j],"Convolve...","text1=[-1 -1 -1\n2 2 2\n-1 -1 -1\n] normalize"); // 0 degree kernel
			j++;
			IJ.run(newpyramid[i][j],"Convolve...","text1=[-1 -1 2\n-1 2 -1\n2 -1 -1\n] normalize"); // 45 degree kernel
			j++;
			IJ.run(newpyramid[i][j],"Convolve...","text1=[-1 2 -1\n-1 2 -1\n-1 2 -1\n] normalize"); // 90 degree kernel
			j++;
			IJ.run(newpyramid[i][j],"Convolve...","text1=[2 -1 -1\n-1 2 -1\n-1 -1 2\n] normalize"); // 135 degree kernel
		}
		
		for(int i=1;i<2;i++)
		{
			for(int j=0;j<4;j++)
			{
				IJ.run(newpyramid[i][j], "Scale...","x=2 y=2");
			}
		}
		return newpyramid;
	}
}