package collections;

public class TextEntry{

    String key;
    Integer amount;

    public TextEntry(String s) {
        key = s;
        amount = 1;
    }

    public TextEntry(String s, Integer i)
    {
        key = s;
        amount = i;
    }

    public void incrementValue() {
        amount += 1;
    }

    public String getKey(){
        return key;
    }

    public int getAmount(){
        return amount;
    }

    @Override
    public String toString() {
        return key + ", " + amount;
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TextEntry other = (TextEntry) obj;
        if (!key.equals(other.key))
            return false;
        //equals специально сравнивает только по полю key
        return true;
    }
}
