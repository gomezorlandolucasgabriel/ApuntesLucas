package es.stemgranada.pt4.pedidos;

/**
 * Representa un producto disponible para su inclusión en un pedido.
 * <p>
 * Cada producto se identifica mediante un código único y dispone de
 * un nombre, una categoría y un precio unitario. Esta información es
 * utilizada por {@link LineaPedido} para calcular el subtotal dentro
 * de un {@link Pedido}.
 * </p>
 *
 * @author TuNombre
 * @version 1.0
 * @since 1.0
 */
public class Producto {

    private final String codigo;
    private final String nombre;
    private final String categoria;
    private final double precioUnitario;

    /**
     * Crea un nuevo producto con la información especificada.
     *
     * @param codigo identificador único del producto; no puede ser {@code null} ni estar en blanco
     * @param nombre nombre descriptivo del producto; no puede ser {@code null} ni estar en blanco
     * @param categoria categoría a la que pertenece el producto; no puede ser {@code null} ni estar en blanco
     * @param precioUnitario precio por unidad del producto; debe ser mayor o igual que {@code 0}
     *
     * @throws IllegalArgumentException si {@code codigo}, {@code nombre} o {@code categoria}
     *                                  son {@code null} o están en blanco
     * @throws IllegalArgumentException si {@code precioUnitario} es negativo
     *
     * @since 1.0
     */
    public Producto(String codigo,
            String nombre,
            String categoria,
            double precioUnitario) {

        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El código no puede estar vacío");
        }

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }

        if (categoria == null || categoria.isBlank()) {
            throw new IllegalArgumentException("La categoría no puede estar vacía");
        }

        if (precioUnitario < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }

        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioUnitario = precioUnitario;
    }

    /**
     * Devuelve el código identificador del producto.
     *
     * @return el código del producto
     * @since 1.0
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Devuelve el nombre del producto.
     *
     * @return el nombre del producto
     * @since 1.0
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve la categoría del producto.
     *
     * @return la categoría del producto
     * @since 1.0
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Devuelve el precio unitario del producto.
     *
     * @return el precio por unidad del producto
     * @since 1.0
     */
    public double getPrecioUnitario() {
        return precioUnitario;
    }
}
