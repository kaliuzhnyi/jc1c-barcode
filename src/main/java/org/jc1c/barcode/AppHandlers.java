package org.jc1c.barcode;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import com.google.zxing.common.HybridBinarizer;
import org.jc1c.annotations.JHandler;
import org.jc1c.annotations.JHandlerControllers;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

@JHandlerControllers
public class AppHandlers {

    @JHandler(methodName = "create_barcode_aztec")
    public static String handlerCreateBarcodeAztec(String data, String imageFormat, Long width, Long height) throws IOException, WriterException {
        return createBarcode(data,
                BarcodeFormat.AZTEC,
                imageFormat.isBlank() ? AppSettings.BARCODE_DEFAULT_FORMAT : imageFormat,
                width == 0 ? AppSettings.BARCODE_AZTEC_DEFAULT_WIDTH : width.intValue(),
                height == 0 ? AppSettings.BARCODE_AZTEC_DEFAULT_HEIGHT : height.intValue());
    }

    @JHandler(methodName = "create_barcode_codabar")
    public static String handlerCreateBarcodeCodabar(String data, String imageFormat, Long width, Long height) throws IOException, WriterException {
        return createBarcode(data,
                BarcodeFormat.CODABAR,
                imageFormat.isBlank() ? AppSettings.BARCODE_DEFAULT_FORMAT : imageFormat,
                width == 0 ? AppSettings.BARCODE_CODABAR_DEFAULT_WIDTH : width.intValue(),
                height == 0 ? AppSettings.BARCODE_CODABAR_DEFAULT_HEIGHT : height.intValue());
    }

    @JHandler(methodName = "create_barcode_code39")
    public static String handlerCreateBarcodeCode39(String data, String imageFormat, Long width, Long height) throws IOException, WriterException {
        return createBarcode(data,
                BarcodeFormat.CODE_39,
                imageFormat.isBlank() ? AppSettings.BARCODE_DEFAULT_FORMAT : imageFormat,
                width == 0 ? AppSettings.BARCODE_CODE39_DEFAULT_WIDTH : width.intValue(),
                height == 0 ? AppSettings.BARCODE_CODE39_DEFAULT_HEIGHT : height.intValue());
    }

    @JHandler(methodName = "create_barcode_code93")
    public static String handlerCreateBarcodeCode93(String data, String imageFormat, Long width, Long height) throws IOException, WriterException {
        return createBarcode(data,
                BarcodeFormat.CODE_93,
                imageFormat.isBlank() ? AppSettings.BARCODE_DEFAULT_FORMAT : imageFormat,
                width == 0 ? AppSettings.BARCODE_CODE93_DEFAULT_WIDTH : width.intValue(),
                height == 0 ? AppSettings.BARCODE_CODE93_DEFAULT_HEIGHT : height.intValue());
    }

    @JHandler(methodName = "create_barcode_code128")
    public static String handlerCreateBarcodeCode128(String data, String imageFormat, Long width, Long height) throws IOException, WriterException {
        return createBarcode(data,
                BarcodeFormat.CODE_128,
                imageFormat.isBlank() ? AppSettings.BARCODE_DEFAULT_FORMAT : imageFormat,
                width == 0 ? AppSettings.BARCODE_CODE128_DEFAULT_WIDTH : width.intValue(),
                height == 0 ? AppSettings.BARCODE_CODE128_DEFAULT_HEIGHT : height.intValue());
    }

    @JHandler(methodName = "create_barcode_datamatrix")
    public static String handlerCreateBarcodeCodeDatamatrix(String data, String imageFormat, Long width, Long height) throws IOException, WriterException {
        return createBarcode(data,
                BarcodeFormat.DATA_MATRIX,
                imageFormat.isBlank() ? AppSettings.BARCODE_DEFAULT_FORMAT : imageFormat,
                width == 0 ? AppSettings.BARCODE_DATAMATRIX_DEFAULT_WIDTH : width.intValue(),
                height == 0 ? AppSettings.BARCODE_DATAMATRIX_DEFAULT_HEIGHT : height.intValue());
    }

    @JHandler(methodName = "create_barcode_ean8")
    public static String handlerCreateBarcodeCodeEan8(String data, String imageFormat, Long width, Long height) throws IOException, WriterException {
        return createBarcode(data,
                BarcodeFormat.EAN_8,
                imageFormat.isBlank() ? AppSettings.BARCODE_DEFAULT_FORMAT : imageFormat,
                width == 0 ? AppSettings.BARCODE_EAN8_DEFAULT_WIDTH : width.intValue(),
                height == 0 ? AppSettings.BARCODE_EAN8_DEFAULT_HEIGHT : height.intValue());
    }

    @JHandler(methodName = "create_barcode_ean13")
    public static String handlerCreateBarcodeCodeEan13(String data, String imageFormat, Long width, Long height) throws IOException, WriterException {
        return createBarcode(data,
                BarcodeFormat.EAN_13,
                imageFormat.isBlank() ? AppSettings.BARCODE_DEFAULT_FORMAT : imageFormat,
                width == 0 ? AppSettings.BARCODE_EAN13_DEFAULT_WIDTH : width.intValue(),
                height == 0 ? AppSettings.BARCODE_EAN13_DEFAULT_HEIGHT : height.intValue());
    }

    @JHandler(methodName = "create_barcode_itf")
    public static String handlerCreateBarcodeCodeItf(String data, String imageFormat, Long width, Long height) throws IOException, WriterException {
        return createBarcode(data,
                BarcodeFormat.ITF,
                imageFormat.isBlank() ? AppSettings.BARCODE_DEFAULT_FORMAT : imageFormat,
                width == 0 ? AppSettings.BARCODE_ITF_DEFAULT_WIDTH : width.intValue(),
                height == 0 ? AppSettings.BARCODE_ITF_DEFAULT_HEIGHT : height.intValue());
    }

    @JHandler(methodName = "create_barcode_pdf417")
    public static String handlerCreateBarcodeCodePdf417(String data, String imageFormat, Long width, Long height) throws IOException, WriterException {
        return createBarcode(data,
                BarcodeFormat.PDF_417,
                imageFormat.isBlank() ? AppSettings.BARCODE_DEFAULT_FORMAT : imageFormat,
                width == 0 ? AppSettings.BARCODE_PDF417_DEFAULT_WIDTH : width.intValue(),
                height == 0 ? AppSettings.BARCODE_PDF417_DEFAULT_HEIGHT : height.intValue());
    }

    @JHandler(methodName = "create_barcode_qr")
    public static String handlerCreateBarcodeCodeQr(String data, String imageFormat, Long width, Long height) throws IOException, WriterException {
        return createBarcode(data,
                BarcodeFormat.QR_CODE,
                imageFormat.isBlank() ? AppSettings.BARCODE_DEFAULT_FORMAT : imageFormat,
                width == 0 ? AppSettings.BARCODE_QR_DEFAULT_WIDTH : width.intValue(),
                height == 0 ? AppSettings.BARCODE_QR_DEFAULT_HEIGHT : height.intValue());
    }

    @JHandler(methodName = "create_barcode_upca")
    public static String handlerCreateBarcodeUpcA(String data, String imageFormat, Long width, Long height) throws IOException, WriterException {
        return createBarcode(data,
                BarcodeFormat.UPC_A,
                imageFormat.isBlank() ? AppSettings.BARCODE_DEFAULT_FORMAT : imageFormat,
                width == 0 ? AppSettings.BARCODE_UPCA_DEFAULT_WIDTH : width.intValue(),
                height == 0 ? AppSettings.BARCODE_UPCA_DEFAULT_HEIGHT : height.intValue());
    }

    @JHandler(methodName = "create_barcode_upce")
    public static String handlerCreateBarcodeUpcE(String data, String imageFormat, Long width, Long height) throws IOException, WriterException {
        return createBarcode(data,
                BarcodeFormat.UPC_E,
                imageFormat.isBlank() ? AppSettings.BARCODE_DEFAULT_FORMAT : imageFormat,
                width == 0 ? AppSettings.BARCODE_UPCE_DEFAULT_WIDTH : width.intValue(),
                height == 0 ? AppSettings.BARCODE_UPCE_DEFAULT_HEIGHT : height.intValue());
    }

    /**
     *
     * @param data string with information to encode
     * @param barcodeFormat type of barcode
     * @param imageFormat type of output image, valid values: JPG, JPEG, PNG, GIF, BMP and WBMP
     * @param width width of output image in pixels
     * @param height height of output image in pixels
     * @return binary image data in Base64
     * @throws IOException
     * @throws WriterException
     */
    public static String createBarcode(String data, BarcodeFormat barcodeFormat, String imageFormat, Integer width, Integer height) throws IOException, WriterException {

        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.MARGIN, 0);

        BitMatrix matrix = new MultiFormatWriter().encode(data, barcodeFormat, width, height, hints);
        MatrixToImageWriter.writeToStream(matrix, imageFormat, stream);

        return new String(Base64.getEncoder().encode(stream.toByteArray()), StandardCharsets.UTF_8);
    }


    @JHandler(methodName = "read_barcode")
    public static String handlerReadBarcode(String data) throws NotFoundException, IOException {
        return readBarcode(data, null);
    }

    @JHandler(methodName = "read_barcode_aztec")
    public static String handlerReadBarcodeAztec(String data) throws NotFoundException, IOException {
        return readBarcode(data, List.of(BarcodeFormat.AZTEC));
    }

    @JHandler(methodName = "read_barcode_codabar")
    public static String handlerReadBarcodeCodabar(String data) throws NotFoundException, IOException {
        return readBarcode(data, List.of(BarcodeFormat.CODABAR));
    }

    @JHandler(methodName = "read_barcode_code39")
    public static String handlerReadBarcodeCode39(String data) throws NotFoundException, IOException {
        return readBarcode(data, List.of(BarcodeFormat.CODE_39));
    }

    @JHandler(methodName = "read_barcode_code93")
    public static String handlerReadBarcodeCode93(String data) throws NotFoundException, IOException {
        return readBarcode(data, List.of(BarcodeFormat.CODE_93));
    }

    @JHandler(methodName = "read_barcode_code128")
    public static String handlerReadBarcodeCode128(String data) throws NotFoundException, IOException {
        return readBarcode(data, List.of(BarcodeFormat.CODE_128));
    }

    @JHandler(methodName = "read_barcode_datamatrix")
    public static String handlerReadBarcodeDatamatrix(String data) throws NotFoundException, IOException {
        return readBarcode(data, List.of(BarcodeFormat.DATA_MATRIX));
    }

    @JHandler(methodName = "read_barcode_ean8")
    public static String handlerReadBarcodeEan8(String data) throws NotFoundException, IOException {
        return readBarcode(data, List.of(BarcodeFormat.EAN_8));
    }

    @JHandler(methodName = "read_barcode_ean13")
    public static String handlerReadBarcodeEan13(String data) throws NotFoundException, IOException {
        return readBarcode(data, List.of(BarcodeFormat.EAN_13));
    }

    @JHandler(methodName = "read_barcode_itf")
    public static String handlerReadBarcodeItf(String data) throws NotFoundException, IOException {
        return readBarcode(data, List.of(BarcodeFormat.ITF));
    }

    @JHandler(methodName = "read_barcode_pdf417")
    public static String handlerReadBarcodePdf417(String data) throws NotFoundException, IOException {
        return readBarcode(data, List.of(BarcodeFormat.PDF_417));
    }

    @JHandler(methodName = "read_barcode_qr")
    public static String handlerReadBarcodeQr(String data) throws NotFoundException, IOException {
        return readBarcode(data, List.of(BarcodeFormat.QR_CODE));
    }

    @JHandler(methodName = "read_barcode_upca")
    public static String handlerReadBarcodeUpcA(String data) throws NotFoundException, IOException {
        return readBarcode(data, List.of(BarcodeFormat.UPC_A));
    }

    @JHandler(methodName = "read_barcode_upce")
    public static String handlerReadBarcodeUpcE(String data) throws NotFoundException, IOException {
        return readBarcode(data, List.of(BarcodeFormat.UPC_E));
    }


    /**
     *
     * @param data binary image data in Base64
     * @return data decoded from barcode
     * @throws IOException
     * @throws NotFoundException
     */
    public static String readBarcode(String data, List<BarcodeFormat> barcodeFormats) throws IOException, NotFoundException {

        byte[] bytes = Base64.getDecoder().decode(data.getBytes(StandardCharsets.UTF_8));

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
        BufferedImageLuminanceSource bufferedImageLuminanceSource = new BufferedImageLuminanceSource(bufferedImage);
        HybridBinarizer hybridBinarizer = new HybridBinarizer(bufferedImageLuminanceSource);
        BinaryBitmap binaryBitmap = new BinaryBitmap(hybridBinarizer);

        Map<DecodeHintType, Object> hints = new HashMap<>();
        hints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        if (!Objects.isNull(barcodeFormats) && !barcodeFormats.isEmpty()) {
            hints.put(DecodeHintType.POSSIBLE_FORMATS, barcodeFormats);
        }

        Result result = new MultiFormatReader().decode(binaryBitmap, hints);
        String text = result.getText();

        return Objects.isNull(text) ? "" : text;
    }

}
