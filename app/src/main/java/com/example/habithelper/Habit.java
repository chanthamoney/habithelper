package com.example.habithelper;

public class Habit {
    private int id;
    private String name;
    private String description;
    private String frequency;
    private String cost;
    private int lock_image;
    private int action_image;
    private boolean is_bad;
    private String owner;

    public Habit(int id, String owner, String name, String description, String frequency, String cost, int lock_image, int action_image, boolean is_bad) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.frequency = frequency;
        this.cost = cost;
        this.lock_image = lock_image;
        this.action_image = action_image;
        this.is_bad = is_bad;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public int getActionImage() {
        return action_image;
    }

    public void setAction_image(int action_image) {
        this.action_image = action_image;
    }

    public int getLockImage() {
        return lock_image;
    }

    public void setLock_image(int lock_image) {
        this.lock_image = lock_image;
    }

    public boolean getIsBad() {
        return is_bad;
    }

    public void setIs_bad(boolean is_bad) {
        this.is_bad = is_bad;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String o) {
        owner = o;
    }
}