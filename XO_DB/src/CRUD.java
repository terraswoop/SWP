import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CRUD {
	public static void addKunde(Connection con, String titelv, String vorname, String nachname, String titeln) {
		try {
			String inserString = "INSERT INTO Kunde (TitelV, Vorname, Nachname, TitelN) VALUES (?,?,?,?);";
			PreparedStatement updateUsers = con.prepareStatement(inserString);
			updateUsers.setString(1, titelv);
			updateUsers.setString(2, vorname);
			updateUsers.setString(3, nachname);
			updateUsers.setString(4, titeln);
			updateUsers.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Attributes aren't right");
		}
	}

	public static void addAdresse(Connection con, String stadt, String strasse, int plz, String hnr) {
		try {
			String inserString = "INSERT INTO adresse (Stadt, Strasse, PLZ, Hnr) VALUES (?,?,?,?);";
			PreparedStatement updateAddress = con.prepareStatement(inserString);
			updateAddress.setString(1, stadt);
			updateAddress.setString(2, strasse);
			updateAddress.setInt(3, plz);
			updateAddress.setString(4, hnr);
			updateAddress.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Attributes aren't right");
		}
	}

	public static void addBestellung(Connection con, int kundeid, int addressrech, int addresslief) {
		try {
			String inserString = "INSERT INTO bestellung_v3 (Kunde_ID, Adresse_Rechnung_ID, Adresse_Liefer_ID) VALUES (?,?,?);";
			PreparedStatement updateBestellung = con.prepareStatement(inserString);
			updateBestellung.setInt(1, kundeid);
			updateBestellung.setInt(2, addressrech);
			updateBestellung.setInt(3, addresslief);
			updateBestellung.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Attributes aren't right");
			System.out.println(e.getMessage());
		}
	}

	public static void addArtikel(Connection con, String name, double preis) {
		try {
			String inserString = "INSERT INTO artikel (Name, Preis) VALUES (?,?);";
			PreparedStatement updateArtikel = con.prepareStatement(inserString);
			updateArtikel.setString(1, name);
			updateArtikel.setDouble(2, preis);
			updateArtikel.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Attributes aren't right");
		}
	}

	public static void addBestArt(Connection con, int bestid, int artid, int menge) {
		try {
			String inserString = "INSERT INTO bestellung_artikel (Bestell_ID, Artikel_ID, Menge) VALUES (?,?,?);";
			PreparedStatement updateArtikel = con.prepareStatement(inserString);
			updateArtikel.setInt(1, bestid);
			updateArtikel.setInt(2, artid);
			updateArtikel.setInt(3, menge);
			updateArtikel.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Attributes aren't right");
			System.out.println(e.getMessage());
		}
	}

	public static void deleteKunde(Connection con, int id) {
		try {
			String deleteString = "DELETE * FROM kunde WHERE ID=?";
			PreparedStatement delKunde = con.prepareStatement(deleteString);
			delKunde.setInt(1, id);
			delKunde.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Attributes aren't right");
		}

	}

	public static void deleteBestellung(Connection con, int id) {
		try {
			String deleteString = "DELETE * FROM bestellung_v3 WHERE ID=?";
			PreparedStatement delBestellung = con.prepareStatement(deleteString);
			delBestellung.setInt(1, id);
			delBestellung.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Attributes aren't right");
		}
	}

	public static void deleteArtikel(Connection con, int id) {
		try {
			String deleteString = "DELETE * FROM artikel WHERE ID=?";
			PreparedStatement delArtikel = con.prepareStatement(deleteString);
			delArtikel.setInt(1, id);
			delArtikel.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Attributes aren't right");
		}
	}

	public static void deleteBestArt(Connection con, int bestid, int artid) {
		try {
			String deleteString = "DELETE * FROM bestellung_artikel WHERE Bestell_ID=? AND Artikel_ID=?";
			PreparedStatement delArtikel = con.prepareStatement(deleteString);
			delArtikel.setInt(1, bestid);
			delArtikel.setInt(2, artid);
			delArtikel.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Attributes aren't right");
		}
	}

	public static void deleteAdresse(Connection con, int id) {
		try {
			String deleteString = "DELETE * FROM adresse WHERE ID=?";
			PreparedStatement delAdresse = con.prepareStatement(deleteString);
			delAdresse.setInt(1, id);
			delAdresse.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Attributes aren't right");
		}
	}

	public static void updateKunde(Connection con, int id, String titelv, String vorname, String nachname,
			String titeln) {
		try {
			String updateString = "UPDATE kunde SET Titelv=?, Vorname=?, Nachname=?, Titeln=? WHERE ID=?";
			PreparedStatement updateKunde = con.prepareStatement(updateString);
			updateKunde.setString(1, titelv);
			updateKunde.setString(2, vorname);
			updateKunde.setString(3, nachname);
			updateKunde.setString(4, titeln);
			updateKunde.setInt(5, id);
			updateKunde.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Attributes aren't right");
		}
	}

	public static void updateBestellung(Connection con, int id, int kid, int arid, int alid) {
		try {
			String updateString = "UPDATE bestellung_v3 SET Kunde_ID=?, Adrresse_Rechnung_ID=?, Adresse_Liefer_ID=?, WHERE ID=?";
			PreparedStatement updateBestellung = con.prepareStatement(updateString);
			updateBestellung.setInt(1, kid);
			updateBestellung.setInt(2, arid);
			updateBestellung.setInt(3, alid);
			updateBestellung.setInt(4, id);
			updateBestellung.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Attributes aren't right");
		}
	}

	public static void updateAdresse(Connection con, int id, String stadt, String strasse, int plz, String hnr) {
		try {
			String updateString = "UPDATE adresse SET Stadt=?, Strasse=?, PLZ=?, Hnr=?, WHERE ID=?";
			PreparedStatement updateAdresse = con.prepareStatement(updateString);
			updateAdresse.setString(1, stadt);
			updateAdresse.setString(2, strasse);
			updateAdresse.setInt(3, plz);
			updateAdresse.setString(4, hnr);
			updateAdresse.setInt(5, id);
			updateAdresse.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Attributes aren't right");
		}
	}

	public static void updateArtikel(Connection con, int id, String name, double preis) {
		try {
			String updateString = "UPDATE artikel SET Stadt=?, Name=?, WHERE ID=?";
			PreparedStatement updateArtikel = con.prepareStatement(updateString);
			updateArtikel.setString(1, name);
			updateArtikel.setDouble(2, preis);
			updateArtikel.setInt(3, id);
			updateArtikel.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Attributes aren't right");
		}
	}

	public static void updateBestArt(Connection con, int bestid, int artid, int menge) {
		try {
			String updateString = "UPDATE bestellung_artikel SET Menge=? WHERE Bestell_ID=? AND Artikel_ID=?";
			PreparedStatement updateBestArt = con.prepareStatement(updateString);
			updateBestArt.setInt(2, bestid);
			updateBestArt.setInt(3, artid);
			updateBestArt.setInt(1, menge);
			updateBestArt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Attributes aren't right");
		}
	}

	public static void selectKunde(Connection con, int id) {
		try {
			String selectString = "SELECT * FROM kunde WHERE id=?";
			PreparedStatement selectKunde = con.prepareStatement(selectString);
			selectKunde.setInt(1, id);
			ResultSet rs = selectKunde.executeQuery();
			rs.next();
			System.out.println("------------------------------");
			System.out.println("TitelV: " + rs.getString("titelv"));
			System.out.println("Vorname: " + rs.getString("vorname"));
			System.out.println("Nachname: " + rs.getString("nachname"));
			System.out.println("TitelN: " + rs.getString("titeln"));
			System.out.println("------------------------------");
		} catch (SQLException e) {
			System.out.println("Attributes aren't right");
		}
	}
	
	public static ResultSet selectKundeRs(Connection con, int id) {
		try {
			String selectString = "SELECT * FROM kunde WHERE id=?";
			PreparedStatement selectKunde = con.prepareStatement(selectString);
			selectKunde.setInt(1, id);
			ResultSet rs = selectKunde.executeQuery();
			return(rs);
		} catch (SQLException e) {
			System.out.println("Attributes aren't right");
			return null;
		}
	}

	public static void selectBestellung(Connection con, int id) {
		try {
			String selectString = "SELECT * FROM bestellung_v3 WHERE id=?";
			PreparedStatement selectBestellung = con.prepareStatement(selectString);
			selectBestellung.setInt(1, id);
			ResultSet rs = selectBestellung.executeQuery();
			rs.next();
			System.out.println("------------------------------");
			System.out.println("ID Kunde: " + rs.getInt("kunde_ID"));
			System.out.println("ID Adresse-Rechnung: " + rs.getInt("adresse_Rechnung_ID"));
			System.out.println("ID Adresse-Lieferunng: " + rs.getInt("adresse_Liefer_ID"));
			System.out.println("------------------------------");
		} catch (SQLException e) {
			System.out.println("Attributes aren't right");
		}
	}
	
	public static ResultSet selectBestellungRs(Connection con, int id) {
		try {
			String selectString = "SELECT * FROM bestellung_v3 WHERE id=?";
			PreparedStatement selectBestellung = con.prepareStatement(selectString);
			selectBestellung.setInt(1, id);
			ResultSet rs = selectBestellung.executeQuery();
			return rs;
		} catch (SQLException e) {
			System.out.println("Attributes aren't right");
			return null;
		}
	}

	public static void selectAdresse(Connection con, int id) {
		try {
			String selectString = "SELECT * FROM adresse WHERE id=?";
			PreparedStatement selectAdresse = con.prepareStatement(selectString);
			selectAdresse.setInt(1, id);
			ResultSet rs = selectAdresse.executeQuery();
			rs.next();
			System.out.println("------------------------------");
			System.out.println("Stadt: " + rs.getString("stadt"));
			System.out.println("Straﬂe: " + rs.getString("strasse"));
			System.out.println("PLZ: " + rs.getInt("plz"));
			System.out.println("Hausnummer: " + rs.getString("hnr"));
			System.out.println("------------------------------");
		} catch (SQLException e) {
			System.out.println("Attributes aren't right");
		}
	}
	
	public static ResultSet selectAdresseRs(Connection con, int id) {
		try {
			String selectString = "SELECT * FROM adresse WHERE id=?";
			PreparedStatement selectAdresse = con.prepareStatement(selectString);
			selectAdresse.setInt(1, id);
			ResultSet rs = selectAdresse.executeQuery();
			return(rs);
		} catch (SQLException e) {
			System.out.println("Attributes aren't right");
			return null;
		}
	}

	public static void selectArtikel(Connection con, int id) {
		try {
			String selectString = "SELECT * FROM kunde WHERE id=?";
			PreparedStatement selectArtikel = con.prepareStatement(selectString);
			selectArtikel.setInt(1, id);
			ResultSet rs = selectArtikel.executeQuery();
			rs.next();
			System.out.println("------------------------------");
			System.out.println("Name: " + rs.getString("name"));
			System.out.println("Preis: " + rs.getInt("preis"));
			System.out.println("------------------------------");
		} catch (SQLException e) {
			System.out.println("Attributes aren't right");
		}
	}

	public static ResultSet selectArtikelRs(Connection con, int id) {
		try {
			String selectString = "SELECT * FROM kunde WHERE id=?";
			PreparedStatement selectArtikel = con.prepareStatement(selectString);
			selectArtikel.setInt(1, id);
			ResultSet rs = selectArtikel.executeQuery();
			return rs;
		} catch (SQLException e) {
			System.out.println("Attributes aren't right");
			return null;
		}
	}
	
	public static void selectBestArt(Connection con, int bestid, int artid) {
		try {
			String selectString = "SELECT * FROM bestellung_artikel WHERE Bestell_ID=? AND Artikel_ID=?";
			PreparedStatement selectBestArt = con.prepareStatement(selectString);
			selectBestArt.setInt(1, bestid);
			selectBestArt.setInt(2, artid);
			ResultSet rs = selectBestArt.executeQuery();
			rs.next();
			System.out.println("------------------------------");
			System.out.println("ID Bestellung: " + rs.getInt("bestell_ID"));
			System.out.println("ID Artikel: " + rs.getInt("artikel_ID"));
			System.out.println("Artikelmenge: " + rs.getInt("menge"));
			System.out.println("------------------------------");
		} catch (SQLException e) {
			System.out.println("Attributes aren't right");
		}
	}
	public static ResultSet selectBestArtRs(Connection con, int bestid, int artid) {
		try {
			String selectString = "SELECT * FROM bestellung_artikel WHERE Bestell_ID=? AND Artikel_ID=?";
			PreparedStatement selectBestArt = con.prepareStatement(selectString);
			selectBestArt.setInt(1, bestid);
			selectBestArt.setInt(2, artid);
			ResultSet rs = selectBestArt.executeQuery();
			return rs;
		} catch (SQLException e) {
			System.out.println("Attributes aren't right");
			return null;
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		Connection c = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/bestellung?serverTimezone=MET",
				"postgres", "root");
		Scanner s = new Scanner(System.in);
		System.out.println(
				"Hello, when asked for a Table, type in Kunde, Bestellung, Adresse, BestellungArtikel or Artikel");
		System.out.println(
				"May i remind you to keep the database scheme by your side, in order to insert the correct attributes for each table.");
		boolean finished = false;
		while (!finished) {
			System.out.println("Type R for read, C for create, U for update or D for delete:");
			String input = s.nextLine();
			if (input.equals("R")) {
				System.out.println("Type in the table-name and ID (2IDs for BestArt) of the entry seperated by one space:");
				input = s.nextLine();
				String in[] = input.split(" ");
				if (in[0].equals("Kunde")) {
					try {
						selectKunde(c, Integer.parseInt((in[1])));
					} catch (Exception e) {
						System.out.println("Looks like this Kunde doesn't exist or you typed shit!");
					}
				} else if (in[0].equals("Bestellung")) {
					try {
						selectBestellung(c, Integer.parseInt((in[1])));
					} catch (Exception e) {
						System.out.println("Looks like this Bestellung doesn't exist or you typed shit!");
					}
				} else if (in[0].equals("Adresse")) {
					try {
						selectAdresse(c, Integer.parseInt((in[1])));
					} catch (Exception e) {
						System.out.println("Looks like this Adresse doesn't exist or you typed shit!");
					}
				} else if (in[0].equals("BestellungArtikel")) {
					try {
						selectBestArt(c, Integer.parseInt((in[1])), Integer.parseInt(in[2]));
					} catch (Exception e) {
						System.out.println("Looks like this BestellungArtikel doesn't exist or you typed shit!");
					}
				} else if (in[0].equals("Artikel")) {
					try {
						selectArtikel(c, Integer.parseInt((in[1])));
					} catch (Exception e) {
						System.out.println("Looks like this Artikel doesn't exist or you typed shit!");
					}
				} else {
					System.out.println("Looks like you failed, try again!");
				}
			} else if (input.equals("C")) {
				System.out.println("Type in the table-name and attributes in the correct order, seperated by one space:");
				input = s.nextLine();
				String in[] = input.split(" ");
				if (in[0].equals("Kunde")) {
					addKunde(c,in[1],in[2],in[3],in[4]);
				} else if (in[0].equals("Bestellung")) {
					addBestellung(c,Integer.parseInt(in[1]),Integer.parseInt(in[2]),Integer.parseInt(in[3]));
				} else if (in[0].equals("Adresse")) {
					addAdresse(c,in[1],in[2],Integer.parseInt(in[3]),in[4]);
				} else if (in[0].equals("BestellungArtikel")) {
					addBestArt(c,Integer.parseInt(in[1]),Integer.parseInt(in[2]),Integer.parseInt(in[3]));
				} else if (in[0].equals("Artikel")) {
					addArtikel(c,in[1], Double.parseDouble(in[2]));
				} else {
					System.out.println("Looks like you failed, try again!");
				}
			} else if (input.equals("U")) {
				System.out
						.println("Type in the table-name and attributes in the correct order, seperated by one space:");
				System.out.println("Attributes you don't want to change must be given the character ':'");
				input = s.nextLine();
				String in[] = input.split(" ");
				if (in[0].equals("Kunde")) {
					for(int i=2;i<in.length;i++) {
						if(in[i].equals(":")) {
							in[i]=selectKundeRs(c,Integer.parseInt(in[1])).getString(i-1);
						}
					}
					updateKunde(c,Integer.parseInt(in[1]),in[2],in[3],in[4],in[5]);
				} else if (in[0].equals("Bestellung")) {
					for(int i=2;i<in.length;i++) {
						if(in[i].equals(":")) {
							in[i]=selectBestellungRs(c,Integer.parseInt(in[1])).getString(i-1);
						}
					}
					updateBestellung(c,Integer.parseInt(in[1]),Integer.parseInt(in[2]),Integer.parseInt(in[3]),Integer.parseInt(in[4]));
				} else if (in[0].equals("Adresse")) {
					for(int i=2;i<in.length;i++) {
						if(in[i].equals(":")) {
							in[i]=selectAdresseRs(c,Integer.parseInt(in[1])).getString(i-1);
						}
					}
					updateAdresse(c,Integer.parseInt(in[1]),in[2],in[3],Integer.parseInt(in[4]),in[5]);
				} else if (in[0].equals("BestellungArtikel")) {
					for(int i=3;i<in.length;i++) {
						if(in[i].equals(":")) {
							in[i]=selectBestArtRs(c,Integer.parseInt(in[1]), Integer.parseInt(in[2])).getString(i-1);
						}
					}
					updateBestArt(c,Integer.parseInt(in[1]),Integer.parseInt(in[2]),Integer.parseInt(in[3]));
				} else if (in[0].equals("Artikel")) {
					for(int i=2;i<in.length;i++) {
						if(in[i].equals(":")) {
							in[i]=selectArtikelRs(c,Integer.parseInt(in[1])).getString(i-1);
						}
					}
					updateArtikel(c,Integer.parseInt(in[1]),in[2],Double.parseDouble(in[3]));
				} else {
					System.out.println("Looks like you failed, try again!");
				}
			}

			else if (input.equals("D")) {
				System.out.println("Type in the table-name and ID (2IDs for BestArt) you want to delete:");
				input = s.nextLine();
				String in[] = input.split(" ");
				if (in[0].equals("Kunde")) {
					deleteKunde(c,Integer.parseInt(in[1]));
				} else if (in[0].equals("Bestellung")) {
					deleteBestellung(c,Integer.parseInt(in[1]));
				} else if (in[0].equals("Adresse")) {
					deleteAdresse(c,Integer.parseInt(in[1]));
				} else if (in[0].equals("BestellungArtikel")) {
					deleteBestArt(c,Integer.parseInt(in[1]),Integer.parseInt(in[2]));
				} else if (in[0].equals("Artikel")) {
					deleteArtikel(c,Integer.parseInt(in[1]));
				} else {
					System.out.println("Looks like you failed, try again!");
				}
			} else {
				System.out.println("Wow, failed already? Please try again or leave!");
			}
			System.out.println("Have you finished? y/n:");
			input = s.nextLine();
			if (input.equals("y")) {
				finished = true;
			}
		}
		System.out.println("See ya!");
		s.close();
		c.close();
	}
}
