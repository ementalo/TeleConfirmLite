package com.ementalo.helpers;

public class Colors {

	public static final String Black = "\u00A70";
	public static final String Navy = "\u00A71";
	public static final String Green = "\u00A72";
	public static final String Blue = "\u00A73";
	public static final String Red = "\u00A74";
	public static final String Purple = "\u00A75";
	public static final String Gold = "\u00A76";
	public static final String LightGray = "\u00A77";
	public static final String Gray = "\u00A78";
	public static final String DarkPurple = "\u00A79";
	public static final String LightGreen = "\u00A7a";
	public static final String LightBlue = "\u00A7b";
	public static final String Rose = "\u00A7c";
	public static final String LightPurple = "\u00A7d";
	public static final String Yellow = "\u00A7e";
	public static final String White = "\u00A7f";

	public static String parseColor(String colour) {
		if (colour.equalsIgnoreCase("black")) {
			return Colors.Black;
		}
		if (colour.equalsIgnoreCase("Navy")) {
			return Colors.Navy;
		}
		if (colour.equalsIgnoreCase("Green")) {
			return Colors.Green;
		}
		if (colour.equalsIgnoreCase("Blue")) {
			return Colors.Blue;
		}
		if (colour.equalsIgnoreCase("Red")) {
			return Colors.Red;
		}
		if (colour.equalsIgnoreCase("Purple")) {
			return Colors.Purple;
		}
		if (colour.equalsIgnoreCase("Gold")) {
			return Colors.Gold;
		}
		if (colour.equalsIgnoreCase("LightGray")) {
			return Colors.LightGray;
		}
		if (colour.equalsIgnoreCase("Gray")) {
			return Colors.Gray;
		}
		if (colour.equalsIgnoreCase("LightGreen")) {
			return Colors.LightGreen;
		}
		if (colour.equalsIgnoreCase("LightBlue")) {
			return Colors.LightBlue;
		}
		if (colour.equalsIgnoreCase("Rose")) {
			return Colors.Rose;
		}
		if (colour.equalsIgnoreCase("LightPurple")) {
			return Colors.LightPurple;
		}
		if (colour.equalsIgnoreCase("Yellow")) {
			return Colors.Yellow;
		}
		if (colour.equalsIgnoreCase("White")) {
			return Colors.White;
		}
		return Colors.Green;
	}
}
