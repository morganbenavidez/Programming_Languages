using System;

public class RobotDrone
{
    public int Lidar { get; set; }
    public int Speed { get; set; }
    public int Temperature { get; set; }
    public int Strength { get; set; }
    public int Camera { get; set; }
    public bool Alive { get; set; }



    public RobotDrone(bool alive, int lidar, int speed, int temperature, int strength, int camera)
    {
        this.Lidar = lidar;
        this.Speed = speed;
        this.Temperature = temperature;
        this.Strength = strength;
        this.Camera = camera;
        this.Alive = alive;
    }

}
