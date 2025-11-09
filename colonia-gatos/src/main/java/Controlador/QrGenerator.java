package Controlador;

import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.awt.image.BufferedImage;
import java.util.Hashtable;

public class QrGenerator {
    public static BufferedImage generarQR(String texto, int width, int height) throws WriterException {
        Hashtable<EncodeHintType, Object> hints = new Hashtable<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        BitMatrix matrix = new MultiFormatWriter().encode(
                texto,
                BarcodeFormat.QR_CODE,
                width,
                height,
                hints
        );

        return MatrixToImageWriter.toBufferedImage(matrix);
    }
}