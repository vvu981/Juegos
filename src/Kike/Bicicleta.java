package Kike;

public class Bicicleta {
    public String marca;
    public double precio;
    public String modelo;

    public Bicicleta(String marca, String modelo) {
    	this.marca = marca;
    	this.modelo = modelo;
    }
    
    public Bicicleta(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }
  
    
    
    public boolean mismaMarca(String marca) {
    	  return this.marca.equalsIgnoreCase(marca);
    }
    
    public String toString() {
       return "Bicicleta " + this.marca + ", modelo " + this.modelo + ", precio " + this.precio;
    }

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
}

 
