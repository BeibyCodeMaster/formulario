package models;

public class Mesa {
    private Integer _id;
    private String _codigo;
    private Integer _capacidad;
    private String _estado;
    private String _ubicacion;
    private Boolean _decorada;
    private byte[] _imagen; // Para almacenar la imagen como BLOB
    private String _imagenRuta; // Para almacenar la ruta de la imagen

    // Getters y setters
    public Integer getId() {
        return _id;
    }

    public void setId(Integer id) {
        this._id = id;
    }

    public String getCodigo() {
        return this._codigo;
    }

    public void setCodigo(String codigo) {
        this._codigo = codigo;
    }

    public Integer getCapacidad() {
        return this._capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this._capacidad = capacidad;
    }

    public String getEstado() {
        return this._estado;
    }

    public void setEstado(String estado) {
        this._estado = estado;
    }

    public String getUbicacion() {
        return this._ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this._ubicacion = ubicacion;
    }

    public Boolean getDecorada() {
        return this._decorada;
    }

    public void setDecorada(boolean decorada) {
        this._decorada = decorada;
    }

    public byte[] getImagen() {
        return this._imagen;
    }

    public void setImagen(byte[] imagen) {
        this._imagen = imagen;
    }
    
    public String getImagenRuta() {
        return this._imagenRuta;
    }

    public void setImagenRuta(String imagenRuta) {
        this._imagenRuta = imagenRuta;
    }
}
