package com.crimsonreborn.crimsonutils.utilities;

import net.minecraft.world.entity.player.Player;

/**
 * Created by Furt on 6/23/2016
 */
public class Location {

	private String dim;
	private Double x, y, z;
	private Float pitch, yaw;

	public Location() {
	}

	public Location(Player player) {

		this.dim = "booger";//player.worldObj.getWorldInfo().getWorldName();
		//EntityPlayerMP p = (EntityPlayerMP) player;
		this.x = player.getX();
		this.y = player.getY();
		this.z = player.getZ();
		this.pitch = player.getXRot();
		this.yaw = player.getYRot();
	}

	public Location(String dim, Double x, Double y, Double z, Float pitch, Float yaw) {
		this.dim = dim;
		this.x = x;
		this.y = y;
		this.z = z;
		this.pitch = pitch;
		this.yaw = yaw;
	}

	public String getDim() {
		return dim;
	}

	public void setDim(String dim) {
		this.dim = dim;
	}

	public Double getX() {
		return x;
	}

	public Double getY() {
		return y;
	}

	public Double getZ() {
		return z;
	}

	public Float getPitch() {
		return pitch;
	}

	public Float getYaw() {
		return yaw;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public void setZ(Double z) {
		this.z = z;
	}

	public void setPitch(Float pitch) {
		this.pitch = pitch;
	}

	public void setYaw(Float yaw) {
		this.yaw = yaw;
	}
}
