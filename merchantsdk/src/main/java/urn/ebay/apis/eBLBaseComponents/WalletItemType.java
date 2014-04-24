package urn.ebay.apis.eBLBaseComponents;

/**
 * Identifies a wallet item of a given type. The format varies depending on the type.
 *
 */
public enum WalletItemType {
	
	MERCHANT_COUPON("MerchantCoupon"),
	LOYALTY_CARD("LoyaltyCard"),
	MANUFACTURER_COUPON("ManufacturerCoupon");
	
	private String value;

	private WalletItemType (String value) {
		this.value = value;
	}

	public String getValue(){
		return value;
	}
	
	public static WalletItemType fromValue(String v) {
		for (WalletItemType c : values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}
}
