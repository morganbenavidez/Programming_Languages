using System;
using System.Collections;
using ScottPlot;
using System.Diagnostics;


public class UnitTesting
{
	public static void Main()
	{

		// List of Lists

		double[] StartingStats = new double[301];
		double[] WinOrLoss = new double[301];
		double[] Times = new double[301];

		double[][] MachineLearning2DArray = new double[301][];
		double[] TempArray = new double[7];


		//var data = new ArrayList();

		Random random = new Random();

		for (int i = 0; i < 300; i++)
		{

			// USE THIS FOR ORIGINAL GRAPH

			//bool a = true;
			//int b = i;
			//int c = i;
			//int d = i;
			//int e = i;
			//int f = i;

			//StartingStats[i] = (double)i;

			bool a = true;
			int b = random.Next(0, 301);
			int c = random.Next(0, 301);
			int d = random.Next(0, 301);
			int e = random.Next(0, 301);
			int f = random.Next(0, 301);


			// Time each Battle
			var watch = new System.Diagnostics.Stopwatch();

			watch.Start();

			double result = (double)MissionControl.Battle(a, b, c, d, e, f);

			watch.Stop();

			double totalTime = (double)watch.ElapsedMilliseconds;

			WinOrLoss[i] = result;
			Times[i] = totalTime;

			Console.WriteLine($"Execution Time: {totalTime} ms");





			// EVERYTHING AFTER THIS IS FOR MACHINE LEARNING SETUP //


			TempArray[0] = result;
			TempArray[1] = b;
			TempArray[2] = c;
			TempArray[3] = d;
			TempArray[4] = e;
			TempArray[5] = f;
			TempArray[6] = totalTime;


			MachineLearning2DArray[i] = TempArray;


			// SET TempArray to 0's //

			TempArray[0] = 0;
			TempArray[1] = 0;
			TempArray[2] = 0;
			TempArray[3] = 0;
			TempArray[4] = 0;
			TempArray[5] = 0;
			TempArray[6] = 0;



		}

		// CODE TO PASS TO CREATE CSV //   THIS IS PART OF MACHINE LEARING COMPONENT - TAKE OFF TO WORK WITH JUST GRAPHING


		var file = @"C:\\Users\\Morgan.Benavidez\\source\\repos\\MLValues.csv";

		using (var stream = File.CreateText(file))
		{
			for (int i = 0; i < MachineLearning2DArray.Count(); i++)
			{
				string first = MachineLearning2DArray[i][0].ToString();
				string second = MachineLearning2DArray[i][1].ToString();
				string third = MachineLearning2DArray[i][2].ToString();
				string fourth = MachineLearning2DArray[i][3].ToString();
				string fifth = MachineLearning2DArray[i][4].ToString();
				string sixth = MachineLearning2DArray[i][5].ToString();
				string seventh = MachineLearning2DArray[i][6].ToString();

				string csvRow = string.Format("{0},{1},{2},{3},{4},{5},{6}", first, second, third, fourth, fifth, sixth, seventh);

				stream.WriteLine(csvRow);
			}
		}



		//for (int i = 0; i < WinOrLoss.Length; i++)
		//      {
		//          Console.WriteLine(StartingStats[i]);
		//	Console.WriteLine($"Win or Loss: {WinOrLoss[i]} ");
		//	Console.WriteLine(Times[i]);
		//}

		var plt = new ScottPlot.Plot(600, 600);
		var cmap = ScottPlot.Drawing.Colormap.Viridis;
		plt.AddColorbar(cmap);

		for (int i = 0; i < 301; i++)
		{
			double x = StartingStats[i];
			double y = Times[i];
			double colorFraction = WinOrLoss[i] * WinOrLoss[i];

			System.Drawing.Color c = ScottPlot.Drawing.Colormap.Viridis.GetColor(colorFraction);
			plt.AddPoint(x, y, c);
		}

		//plt.SaveFig("C:\\Users\\Morgan.Benavidez\\source\\repos\\Scatter.png");

		// plt.AddScatter(StartingStats, Times);

		//plt.SaveFig("C:\\Users\\Morgan.Benavidez\\source\\repos\\Scatter.png");



	}
}
