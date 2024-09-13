package io.compiler.types;

public class Var {
    private String id;
    private Types type;
    private Boolean initialized;
    private Boolean used = false;

    public Var(String id, Types type) {
        super();
        this.id = id;
        this.type = type;
        this.initialized = false;
        this.used = false;
    }

    public Var(String id) {
        super();
        this.id = id;
        this.initialized = false;
        this.used = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }
    
    public Boolean isUsed() {
        return used;
    }
    public void setUsed(Boolean value) {
    	this.used = value;
    }

    public Boolean isInitialized() {
        return initialized;
    }

    public void setInitialized(Boolean initialized) {
        this.initialized = initialized;
    }

    @Override
    public String toString() {
        return "Var [id=" + id + ", type=" + type + ", initialized=" + initialized + "]";
    }
}
