package basic;

public class PhysicalBox {
	public static void main(String[] args) {
		Box geometryBox = new Box(10.5,10,10);
		System.out.println("Volume of geometry box is:"+geometryBox.volume());
		System.out.println("Surface area of geometry box is:"+geometryBox.surfaceArea());
		Box container = geometryBox;
		//Box container = new Box(100,100,50);
		System.out.println("Volume of container is:"+container.volume());
		System.out.println("Surface area of cotainer box is:"+container.surfaceArea());
		System.out.println("This container can contain "+(int)(container.volume()/geometryBox.volume())+" geometryboxes");
	    geometryBox = new Box(5,5,5);
	    geometryBox.height = 10;
	    System.out.println(geometryBox.volume());
	    System.out.println(container.volume());
	}
	
	
}
