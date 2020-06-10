package Model.Tile.Units;

public class Resource {
    private int pool;
    private int amount;

    public Resource(int pool,int amount)
    {
        this.pool=pool;
        this.amount=amount;
    }

    public int getPool()
    {
        return pool;
    }

    public int getAmount() {
        return amount;
    }

    public void setPool(int newPool)
    {
        pool=newPool;
    }

    public void setAmount(int newAmount)
    {
        if(newAmount>pool)
        {
            amount=pool;
        }
        else if(newAmount<0)
        {
            amount=0;
        }
        else
        {
            amount=newAmount;
        }
    }
}
