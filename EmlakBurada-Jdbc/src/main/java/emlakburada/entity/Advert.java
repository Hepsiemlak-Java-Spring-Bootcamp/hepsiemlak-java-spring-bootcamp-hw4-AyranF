package emlakburada.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Advert {

	public Date timestamp;
	public int id;
	public int advertNo;
	// private RealEstate gayrimenkul;
	public String baslik;
	public int creatorUserId; // hem bireysel & kurumsal
	public String[] resimList = new String[5];
	public BigDecimal fiyat;
	public int suresi;
	public boolean oneCikarilsinMi = false;
	public boolean incelendiMi = false;
	public Date olusturulmaTarihi;
	//public boolean aktifMi = true;

	public Advert(int id, int advertNo, int creatorUser, String baslik) {
		super();
		this.id = id;
		this.advertNo = advertNo;
		this.baslik = baslik;
		this.creatorUserId = creatorUser;
	}

	public Advert() {
		// TODO Auto-generated constructor stub
	}
}