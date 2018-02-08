/**
 * FeedForward.java
 * @author Ahmad Alsabagh
 * @date November 28th, 2016
 * Application for image recognition, automatically assigns
 * a categorical label to an image based on its contents
 * */
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.*;


public class FeedForward
{
  //main method
  public static void main(String[] args) throws IOException
  {  
    BufferedImage img = ImageIO.read(new File(args[0]));
    double[] dummy = null;
    double[] x = img.getData().getPixels(0, 0, img.getWidth(),img.getHeight(), dummy);
    biggestNumber(sigmoid(outputPerceptron(sigmoid(scale(perceptron(x))))));
  }
  
  /*
   * Scales numbers to a number between 0 and 1
   * @param pixels an array of pixels with numbers to scale
   * @return pixels a scaled array
   * */
  public static double[] scale(double[] pixels)
  {
    final double SCALE_AMOUNT = 255.0; 
    for (int i = 0; i < pixels.length ; i++)
    {
      pixels[i] = pixels[i]/SCALE_AMOUNT;
    }
    return pixels;
  }
  
  /*
   * Takes input of 784 pixels and multiplies by weight then adds bias for 300 rows
   * @param pixels an array of image pixels
   * @return total an array of 300 numbers
   * */
  public static double[] perceptron(double[] pixels) throws IOException
  {
    double[] total = new double[300];
    Scanner input = new Scanner(new File("hidden-weights.txt"));
    for (int j = 0; j < 300; j++)
    {
      for (int i = 0 ; i < pixels.length; i++)
      {
        total[j] = total[j] + pixels[i] * input.nextDouble();
      }
      total[j] = total[j] + input.nextDouble(); //Add the bias
    }
    input.close();
    return total;
  }
  
  /*
   * performs sigmoid function on an array
   * @param an array of numbers
   * @return an array after the function is applied
   * */
  public static double[] sigmoid(double[] value)
  {
    final double NEGATIVE_ONE = -1;
    double[] function = new double[value.length];
    for (int i = 0; i < value.length; i++)
    {
      function[i] = 1/(1 + Math.exp(NEGATIVE_ONE * value[i])); 
    }
    return function;
  }
  
  /*
   * Takes the array of 300 numbers and produces an array of 10
   * @param pixels an array with 300 numbers
   * @return an array with 10 numbers
   * */
  public static double[] outputPerceptron(double[] pixels) throws IOException
  {
    double[] total = new double[10];
    Scanner input = new Scanner(new File("output-weights.txt"));
    for (int i = 0; i < 10; i++)
    {
      for (int j = 0; j < pixels.length; j++)
      {
        total[i] = total[i] + pixels[j] * input.nextDouble();
      }
      total[i] = total[i] + input.nextDouble();
    } 
    input.close();
    return total;
  }
  
  /*
   * Finds the biggest number & position in a given array
   * @param total an array to be searched
   * */
  public static void biggestNumber(double[] total) throws IOException
  {   
    double biggest = total[0];
    int position = 0;
    
    for (int k = 0; k < total.length; k++)
    {
      if (biggest < total[k])
      {
        biggest = total[k];
        position = k;
      }
    }
    System.out.println("The network prediction is: " + position);
  }
}