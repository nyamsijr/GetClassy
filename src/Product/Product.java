package Product;

public class Product {
    private String ID;
    private String Name;
    private String Description;
    private double Cost;

    public Product(String ID, String Name, String Description, double Cost) {
        this.ID = ID;
        this.Name = Name;
        this.Description = Description;
        this.Cost = Cost;
    }
    public String toCSVDataRecord() {
        return ID + "," + Name + "," + Description + "," + Cost;
    }
    public String toJSON() {
        return "{" +
                "\"ID\": \"" + ID + "\"," +
                "\"Name\": \"" + Name + "\"," +
                "\"Description\": \"" + Description + "\"," +
                "\"Cost\": \"" + Cost + "\"," +
                "}";

        }
    public String toXML() {
        return "<Product>" +
                "<ID>" + ID + "</ID>" +
                "<Name>" + Name + "</Name>" +
                "<Description>" + Description + "</Description>" +
                "<Cost>" + Cost + "</Cost>" +
                "</Product>";
    }
    @Override
    public String toString() {
    return "ID: " + ID + " Name: " + Name + " Description: " + Description + " Cost: " + Cost;
}

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getCost() {
        return Cost;
    }

    public void setCost(double cost) {
        Cost = cost;
    }
}