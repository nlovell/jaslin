package net.nlovell.jaslin.tools;

public class MyInt {
    private int me;

    public MyInt(int inT){
        setMe(inT);
    }

    public MyInt copy(){
        return new MyInt(this.getMe());
    }

    public void setMe(int set){
        this.me = set;
    }

    public int getMe(){
        return this.me;
    }

    @Override
    public String toString(){
        return String.valueOf(getMe());
    }

}
