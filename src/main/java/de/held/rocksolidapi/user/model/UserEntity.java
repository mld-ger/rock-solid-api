package de.held.rocksolidapi.user.model;

import java.util.Objects;

public class UserEntity {

	private final InventoryAggregate inventory = new InventoryAggregate();
	private double money;

	public UserEntity(double money) {
		this.money = money;
	}

	public InventoryAggregate getInventory() {
		return inventory;
	}

	public double getMoney() {
		return money;
	}

	public void deductMoney(Double value) {
		if (money >= value) {
			money -= value;
		} else {
			throw new IllegalArgumentException("Not enough money to reduce from user.");
		}
	}

	public void addMoney(Double value) {
		money += value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		UserEntity user = (UserEntity) o;
		return Double.compare(user.money, money) == 0 &&
				Objects.equals(inventory, user.inventory);
	}

	@Override
	public int hashCode() {
		return Objects.hash(inventory, money);
	}

}
