import java.awt.Dimension;
import java.awt.image.BufferedImage;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;


public class VLCCapture
{
  private static final int IM_WIDTH = 640;
  private static final int IM_HEIGHT = 480;

  private static String CAP_DEVICE = "";//"dshow://";     // for Windows
                                   // "v4l2:///dev/video0"    // for Linux
                                   // "qtcapture://"          // for MAC OS X

  private static String VID_NAME = "";
                         //"Integrated Webcam";     // win 7 webcam


  private static final String[] VLC_ARGS = {
    "--intf", "dummy",              // no interface
    "--vout", "dummy",              // no video output
    "--no-audio",                   // no audio decoding
    "--no-video-title-show",        // do not display title
    "--no-stats",                   // no stats
    "--no-sub-autodetect-file",     // no subtitles
    "--no-snapshot-preview",        // no snapshot previews
    "--live-caching=50",            // reduce capture lag/latency
    "--quiet",                      // turn off warnings and info messages
  };

  // used while waiting for the media player to be initialized
  private static final int MAX_TRIES = 7;
  private static final int TRY_PERIOD = 1000;   // ms



  private MediaPlayerFactory factory = null;
  private MediaPlayer mPlayer = null;

  // dimensions of the the snapped image
  private Dimension imageSize = null;
  private boolean isClosed = true;   // since device is not available yet


  public VLCCapture()
  {
    java.util.Scanner s = null;
    String video_device="";
    String video_mrl="";
    String temp="";
    try {
            s = new java.util.Scanner(new java.io.BufferedReader(new java.io.FileReader("activecamera")));
            s.useLocale(java.util.Locale.US);
		while (s.hasNext()) {
                    if (s.hasNextLine()) {
			video_device = s.nextLine();
			} else {
				break;
			}
                    if(s.hasNextLine()){
                        video_mrl=s.nextLine();
                    }else{
                        break;
                    }
		}
	}catch(java.io.IOException ert){
		javax.swing.JOptionPane.showMessageDialog(null,ert, "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        s.close();
        
        if(video_device.equals("default")){
            try {
            s = new java.util.Scanner(new java.io.BufferedReader(new java.io.FileReader("defaultcamera")));
            s.useLocale(java.util.Locale.US);
		while (s.hasNext()) {
                    if (s.hasNextLine()) {
			video_device = s.nextLine();
			} else {
				break;
			}
                    if(s.hasNextLine()){
                        video_mrl=s.nextLine();
                    }else{
                        break;
                    }
		}
	}catch(java.io.IOException ert){
		javax.swing.JOptionPane.showMessageDialog(null,ert, "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        s.close();
        }
           
      VID_NAME = video_device;
      CAP_DEVICE = video_mrl;
      
      temp = video_mrl;
      temp = temp.substring(0, temp.indexOf(":"));
      
    factory = new MediaPlayerFactory(VLC_ARGS);
    mPlayer = factory.newHeadlessMediaPlayer();

    String[] options = {
      ":"+temp+"-vdev=" + VID_NAME,
      ":"+temp+"-size=" + IM_WIDTH+"x"+IM_HEIGHT,
      ":"+temp+"-adev=none",    // no audio device required
    };
    mPlayer.startMedia(CAP_DEVICE, options);

    waitForFirstSnap();
  } // end of VLCCapture() constructor



  private void waitForFirstSnap()
  /* Wait for the media player to be deliver first snap.
     May take several seconds to initialize this object, 
     so this method makes up to MAX_TRIES attempts.
  */
  {
    int tryCount = MAX_TRIES;
    System.out.println("Initializing media player...");
    while (tryCount > 0) {
      BufferedImage im = getSnap();
      if (im != null) {   // snapping works
        imageSize = new Dimension( im.getWidth(),im.getHeight());
        break;
      }
      try {   // initialization failed so wait a while and try again
        System.out.println("Waiting...");
		    Thread.sleep(TRY_PERIOD);
      }
      catch (InterruptedException e)
      {  System.out.println(e);  }
      tryCount--;
    }

    if (tryCount == 0) {
      System.out.println("Giving Up");
      System.exit(0);
    }

    isClosed = false;   // device now available
  }  // end of waitForFirstSnap()



  private BufferedImage getSnap()
  {
    BufferedImage im = mPlayer.getSnapshot(IM_WIDTH, 0);   
                 // get image with aspect ratio maintained

    if ((im == null) || (im.getWidth() == 0)) {
      System.out.println("No snap available");
      return null;
    }
    return im;
  }  // end of getSnap()


  public Dimension getFrameSize()
  {  
    if (imageSize == null)
      return new Dimension(IM_WIDTH, IM_HEIGHT);
    else
      return imageSize;
  } // end of getFrameSize()



  public int getFrameRate()
  {  return 100; }    // determined by observing SnapPics executing on a slow machine



  synchronized public BufferedImage getImage()
  {  return (isClosed) ? null : getSnap();  } 


  synchronized public void close()
  /* close() and getImage() are synchronized so that it's not
     possible to close down the player while a frame is being
     snapped. */
  {  
    if (isClosed)
      return;

    if(mPlayer != null) {
      mPlayer.release();
      mPlayer = null;
    }
    
    if(factory != null) {
      factory.release();
      factory = null;
    }

    isClosed = true;
  }  // end of close()


  public boolean isClosed()
  {  return isClosed;  }


} // end of VLCCapture class
