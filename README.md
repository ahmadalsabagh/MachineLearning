# Machine Learning Project
Simplified machine learning assignment in Java

## Assignment Description
1.	Read in the weights and biases for both the hidden and output layers from the files hidden-weights.txt and output-weights.txt, respectively. Each row of the files contains the weights for a neuron, with the last value corresponding to the bias. In hidden-weights.txt there should be 300 rows with 785 values per row (784 weights + 1 bias). In output-weights.txt, there should be 10 rows by 301 values per row (300 weights + 1 bias).  
 
2.	Read in image (the filename is to be provided at the command line).   
 
The Java standard library package java.awt.image contains a class BufferedImage whose objects represent two-dimensional pixel raster images. To read in the image and place it in a one dimensional array (each image row concatenated after the previous one) use the following code:    
 
img = ImageIO.read(new File("src/number.png"));   
 
// get pixel data double[] dummy = null;  
double[] X = img.getData().getPixels(0, 0, img.getWidth(),     img.getHeight(), dummy);   
You will have to include the following packages to read in an image:  
 
import javax.imageio.ImageIO; import java.awt.image.BufferedImage; import java.io.*;  
 	 
3.	You will next need to rescale the values of the input image from its original range of 0 to 255 to the required range 0 to 1.  
 
4.	Given the input image, compute the outputs for the hidden layer.  
  
5.	Given the results of the hidden layer as input, compute the results of the output layer.  
 
6.	Print to the screen the label of the output neuron with the highest value, this corresponds to the prediction of your neural network based on the input image. Your code should print to the screen the following: “The network prediction is
XX.”, where XX corresponds to the digit class with the highest ANN output value.  
