package de.dhbw.experimental;

import java.time.ZonedDateTime;
import java.util.Objects;

public abstract class AbstractProduct implements Food {

    private String name;
    private FoodGroup foodGroup;

    private ZonedDateTime bestBeforeDate;

    public AbstractProduct(FoodGroup foodGroup, String name) {
        this.foodGroup = foodGroup;
        this.name = name;
    }

    @Override
    public FoodGroup getFoodGroup() {
        return foodGroup;
    }

    @Override
    public void setFoodGroup(FoodGroup foodGroup) {
        this.foodGroup = foodGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZonedDateTime getBestBeforeDate() {
        return bestBeforeDate;
    }

    public String getBestBeforeDateAsString() {
        if (bestBeforeDate != null) {
            return String.format(
                    "%s/%s/%s",
                    bestBeforeDate.getDayOfMonth(),
                    bestBeforeDate.getMonthValue(),
                    bestBeforeDate.getYear());
        }
        return "not-set";
    }

    public void setBestBeforeDate(ZonedDateTime bestBeforeDate) {
        this.bestBeforeDate = bestBeforeDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractProduct that = (AbstractProduct) o;
        return name.equals(that.name) && foodGroup == that.foodGroup;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, foodGroup);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", foodGroup=" + foodGroup +
                ", bestBeforeDate=" + getBestBeforeDateAsString() +
                '}';
    }

}