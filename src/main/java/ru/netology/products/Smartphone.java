package ru.netology.products;

import java.util.Objects;

public class Smartphone extends Product {
    private String maker;

    public Smartphone() {
    }

    public Smartphone(int id, String name, int price, String maker) {
        super(id, name, price);
        this.maker = maker;
    }

    @Override
    public boolean matches(String text) {
        return super.matches(text) || maker.contains(text);
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone that = (Smartphone) o;
        return Objects.equals(maker, that.maker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maker);
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "maker='" + maker + '\'' +
                '}';
    }
}
