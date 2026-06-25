package oopexam.dip;

public class STV extends TV {
    boolean power;
    int volume;

    public STV(){
        this.power = false;
        this.volume=0;
    }

    @Override
    public void on(){
        this.power = true;
    }

    @Override
    public void off(){
        this.power = false;
    }

    @Override
    public void volumeUp(){
        if(power){
            volume++;
        }
    }

    @Override
    public void volumeDown(){
        if(power){
            volume--;
        }
    }

    @Override
    public String toString(){
        return "STV [power=" + power + ", volume=" + volume + "]";
    }
}
