package Connect;

import java.io.Serializable;

public abstract class ConstantJ implements Serializable
{
	public static final String
	server					= "62.79.16.16",  // database-serveren
	database				= "grp17",  //"jdbcdatabase", // navnet paa din database = dit studienummer
	username				= "grp17", // dit brugernavn = dit studienummer 
	password				= "rfkcFb5y"; // dit password som du har valgt til din database

	public static final int
	port					= 3306;
}
