import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;


public class GeradoraDeFigurinhas {

    public void cria (InputStream inputStream, String nomeArquivo) throws IOException {
        //leitura da imagem
        //InputStream inputStream = new URL().openStream();
        BufferedImage imagemOriginal =  ImageIO.read(inputStream);

        //cria nova imagem com transparencia e tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //copiar a nova imagem para nova imagem
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null );

        //configurar fonte
        Font font = new Font(Font.SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(font);


        //escrever uma frase na nova imagem
        graphics.drawString("RECOMENDO!!!", 100, novaAltura -100);

        //escrevar a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo) );

    }
}
