package madrabbit.ui.images;

import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class MadRabbitImages {
    public static Image icoRabbit;
    public static Image rabbitImage;
    public static Image wolfImage;

    static {
        Device display = Display.getDefault();
        icoRabbit = new Image(display, MadRabbitImages.class.getResourceAsStream("icoRabbit.png"));

        wolfImage = new Image(display, MadRabbitImages.class.getResourceAsStream("wolf.png"));
        rabbitImage = new Image(display, MadRabbitImages.class.getResourceAsStream("rabbit.png"));
    }
}
