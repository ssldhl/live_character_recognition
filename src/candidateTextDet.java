import ij.ImagePlus;

public class candidateTextDet
{
	private multiscaleEdgeDet msed;
	private featureMapGen fmg;
	public ImagePlus candidateTextDet(ImagePlus I)
	{
		msed = new multiscaleEdgeDet();
		fmg = new featureMapGen();
		
		int height = I.getHeight();
		int width = I.getWidth();
		ImagePlus[][] Im = new ImagePlus[2][4];
		
		Im = msed.multiscaleEdgeDet(I,height,width);
		ImagePlus fm = fmg.featureMapGen(Im,height,width);
		
		return fm;
	}
}