import java.util.List;

public final class App {
    public static void main(String[] args) {
        List<Linea> compra = List.of(new Linea("Cuaderno 200 hojas", 2, 275), new Linea("Calculadora científica", 1, 1450));
        System.out.println(Reporte.resumen(compra));
    }
}
