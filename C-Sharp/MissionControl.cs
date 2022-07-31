using System;
using System.Collections;

public class MissionControl
{


	public static int Battle(bool a, int b, int c, int d, int e, int f)
	{

		int tempIncrement = 10;
		int speedIncrement = 20;
		//int cameraView = 0;

		RobotDrone Theta = new RobotDrone(a, b, c, d, e, f);

		RobotDrone Omega = new RobotDrone(a, b, c, d, e, f);

		RobotDrone Delta = new RobotDrone(a, b, c, d, e, f);

		Target Megatron = new Target(100);

		//Alpha.Lidar += 5;

		Console.WriteLine(Theta.Lidar);
		Console.WriteLine(Omega.Lidar);
		Console.WriteLine(Delta.Lidar);
		Console.WriteLine(Megatron.Defense);

		Console.WriteLine($"I am Megatron, my defense is {Megatron.Defense}!");

		while (Megatron.Defense > 0
				&& (Theta.Alive == true
				|| Omega.Alive == true
				|| Delta.Alive == true))
		{
			// Handle Alpha First
			if (Theta.Alive == true)
			{
				RobotDrone Alpha = Theta;
				string Name = "Theta";
				Random random = new Random();
				Alpha.Lidar = random.Next(0, 21);
				Alpha.Camera = random.Next(0, 21);
				Console.WriteLine(Alpha.Lidar);

				if (Alpha.Camera >= 7 && Alpha.Camera <= 11)
				{
					Megatron.Defense -= Alpha.Strength;
					Console.WriteLine($"{Name} has fired and struck Megatron!");
				}

				if (Alpha.Lidar == 0 || Alpha.Lidar == 1)
				{
					Alpha.Alive = false;
					Console.WriteLine($"{Name} has crashed into an object!");
				}
				else if (Alpha.Lidar < 10)
				{
					Alpha.Speed -= speedIncrement;
					Alpha.Temperature -= tempIncrement;
				}
				else if (Alpha.Lidar >= 10)
				{
					Alpha.Speed += speedIncrement;
					Alpha.Temperature += tempIncrement;
				}

				if (Alpha.Speed > 300)
				{
					Alpha.Alive = false;
					Console.WriteLine($"{Name} has gone too fast and crashed!");
				}
				else if (Alpha.Speed <= 10)
				{
					Alpha.Alive = false;
					Console.WriteLine($"{Name} engines have stalled and caused a crash!");
				}

				if (Alpha.Temperature > 150)
				{
					Alpha.Alive = false;
					Console.WriteLine($"{Name} engines overheated and caused a crash!");
				}
				else if (Alpha.Temperature <= 10)
				{
					Alpha.Alive = false;
					Console.WriteLine($"{Name} engines have lost power and caused a crash!");
				}


			}

			if (Omega.Alive == true)
			{
				RobotDrone Alpha = Omega;
				string Name = "Omega";
				Random random = new Random();
				Alpha.Lidar = random.Next(0, 21);
				Alpha.Camera = random.Next(0, 21);
				Console.WriteLine(Alpha.Lidar);

				if (Alpha.Camera >= 7 && Alpha.Camera <= 11)
				{
					Megatron.Defense -= Alpha.Strength;
					Console.WriteLine($"{Name} has fired and struck Megatron!");
				}

				if (Alpha.Lidar == 0 || Alpha.Lidar == 1)
				{
					Alpha.Alive = false;
					Console.WriteLine($"{Name} has crashed into an object!");
				}
				else if (Alpha.Lidar < 10)
				{
					Alpha.Speed -= speedIncrement;
					Alpha.Temperature -= tempIncrement;
				}
				else if (Alpha.Lidar >= 10)
				{
					Alpha.Speed += speedIncrement;
					Alpha.Temperature += tempIncrement;
				}

				if (Alpha.Speed > 300)
				{
					Alpha.Alive = false;
					Console.WriteLine($"{Name} has gone too fast and crashed!");
				}
				else if (Alpha.Speed <= 10)
				{
					Alpha.Alive = false;
					Console.WriteLine($"{Name} engines have stalled and caused a crash!");
				}

				if (Alpha.Temperature > 150)
				{
					Alpha.Alive = false;
					Console.WriteLine($"{Name} engines overheated and caused a crash!");
				}
				else if (Alpha.Temperature <= 10)
				{
					Alpha.Alive = false;
					Console.WriteLine($"{Name} engines have lost power and caused a crash!");
				}


			}

			if (Delta.Alive == true)
			{
				RobotDrone Alpha = Delta;
				string Name = "Delta";
				Random random = new Random();
				Alpha.Lidar = random.Next(0, 21);
				Alpha.Camera = random.Next(0, 21);
				Console.WriteLine(Alpha.Lidar);

				if (Alpha.Camera >= 7 && Alpha.Camera <= 11)
				{
					Megatron.Defense -= Alpha.Strength;
					Console.WriteLine($"{Name} has fired and struck Megatron!");
				}

				if (Alpha.Lidar == 0 || Alpha.Lidar == 1)
				{
					Alpha.Alive = false;
					Console.WriteLine($"{Name} has crashed into an object!");
				}
				else if (Alpha.Lidar < 10)
				{
					Alpha.Speed -= speedIncrement;
					Alpha.Temperature -= tempIncrement;
				}
				else if (Alpha.Lidar >= 10)
				{
					Alpha.Speed += speedIncrement;
					Alpha.Temperature += tempIncrement;
				}

				if (Alpha.Speed > 300)
				{
					Alpha.Alive = false;
					Console.WriteLine($"{Name} has gone too fast and crashed!");
				}
				else if (Alpha.Speed <= 10)
				{
					Alpha.Alive = false;
					Console.WriteLine($"{Name} engines have stalled and caused a crash!");
				}

				if (Alpha.Temperature > 150)
				{
					Alpha.Alive = false;
					Console.WriteLine($"{Name} engines overheated and caused a crash!");
				}
				else if (Alpha.Temperature <= 10)
				{
					Alpha.Alive = false;
					Console.WriteLine($"{Name} engines have lost power and caused a crash!");
				}


			}

		}
		if (Megatron.Defense <= 0)
		{
			Console.WriteLine("The mission was a success, you defeated Megatron!");
			return 1;
		}
		else
		{
			Console.WriteLine("The mission was a failure, all your drones were destroyed and Megatron is destroying the world...");
			return 0;
		}



	}
}

