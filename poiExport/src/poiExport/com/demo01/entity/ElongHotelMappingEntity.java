package poiExport.com.demo01.entity;

import lombok.Data;

@Data
public class ElongHotelMappingEntity {
	// 艺龙M酒店ID
	private String elongHotelId;
	// 艺龙M酒店名称
	private String elongHotelName;
	// 供应商酒店ID
	private String fcHotelId;
	// 供应商酒店名称
	private String fcHotelName;
	// 艺龙M房型ID
	private String elongRoomId;
	// 艺龙M房型名称
	private String elongRoomName;
	// 供应商房型ID
	private String fcRoomId;
	// 供应商房型名称
	private String fcRoomName;
	// 供应商RPID
	private String fcRatePlanId;
	// 供应商RP名称
	private String fcRatePlanName;

	public ElongHotelMappingEntity(String elongHotelId, String elongHotelName, String fcHotelId, String fcHotelName,
			String elongRoomId, String elongRoomName, String fcRoomId, String fcRoomName, String fcRatePlanId,
			String fcRatePlanName) {
		super();
		this.elongHotelId = elongHotelId;
		this.elongHotelName = elongHotelName;
		this.fcHotelId = fcHotelId;
		this.fcHotelName = fcHotelName;
		this.elongRoomId = elongRoomId;
		this.elongRoomName = elongRoomName;
		this.fcRoomId = fcRoomId;
		this.fcRoomName = fcRoomName;
		this.fcRatePlanId = fcRatePlanId;
		this.fcRatePlanName = fcRatePlanName;
	}

	public ElongHotelMappingEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
