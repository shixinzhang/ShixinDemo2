package net.sxkeji.shixinandroiddemo2.beans;


import net.sxkeji.shixinandroiddemo2.views.sortlistview.SortModel;

import java.io.Serializable;
import java.util.List;

/**
 * 本地汽车品牌实体类
 * Created by zhangshixin on 7/11/2016.
 */
public class CarBrandBean implements Serializable {

    /**
     * carBrandListVersion : 0
     * carBrandList : [{"id":"2a88eafe-b977-48a7-af58-a4ed00ecd300","displayOrder":null,"name":"奥迪","firstLetter":"A","logoUrl":"http://img.yaomaiche.com/upload/image/original/201508/171340516914.png","inventory":null},{"id":"76f4f7c2-ca27-44c9-82ee-a4ed00ecd300","displayOrder":null,"name":"宝马","firstLetter":"B","logoUrl":"http://img.yaomaiche.com/upload/image/original/201510/222109576440.png","inventory":null},{"id":"05b886c2-6c2d-4fd4-8734-a4ed00ecd300","displayOrder":null,"name":"比亚迪","firstLetter":"B","logoUrl":"http://img.yaomaiche.com/upload/image/original/201508/171341491701.png","inventory":null},{"id":"b39740fe-4a3c-4050-8ec4-a4ed00ecd300","displayOrder":null,"name":"奔驰","firstLetter":"B","logoUrl":"http://img.yaomaiche.com/upload/image/original/201508/201505145311.png","inventory":null},{"id":"d76f2674-e1f5-4462-9438-a4ed00ecd300","displayOrder":null,"name":"标致","firstLetter":"B","logoUrl":"http://img.yaomaiche.com/upload/image/original/201508/201503529815.png","inventory":null},{"id":"f2b5a15d-0b51-4e03-9ac8-a4ed00ecd300","displayOrder":null,"name":"宝骏","firstLetter":"B","logoUrl":"http://img.yaomaiche.com/upload/image/original/201510/082052147348.png","inventory":null},{"id":"79593743-ae0d-412e-9d99-a4ed00ecd300","displayOrder":null,"name":"本田","firstLetter":"B","logoUrl":"http://img.yaomaiche.com/upload/image/original/201508/171343075498.png","inventory":null},{"id":"ea760643-6c00-4327-b913-a4ed00ecd300","displayOrder":null,"name":"别克","firstLetter":"B","logoUrl":"http://img.yaomaiche.com/upload/image/original/201508/171342194020.png","inventory":null},{"id":"8e13baa4-8ad2-4664-ab33-a4ed00ecd301","displayOrder":null,"name":"保时捷","firstLetter":"B","logoUrl":"http://img.yaomaiche.com/upload/image/original/201508/201502071323.png","inventory":null},{"id":"12a5f184-6d02-47a1-9054-a4f700e44e59","displayOrder":null,"name":"标致","firstLetter":"B","logoUrl":"http://img.yaomaiche.com/upload/image/original/201508/171351123981.png","inventory":null},{"id":"aa4576dd-113e-428a-bef5-a4ed00ecd300","displayOrder":null,"name":"长城","firstLetter":"C","logoUrl":"http://img.yaomaiche.com/upload/image/original/201508/201514327424.png","inventory":null},{"id":"525d2826-3ca4-43ac-9e5f-a4ed00ecd300","displayOrder":null,"name":"大众","firstLetter":"D","logoUrl":"http://img.yaomaiche.com/upload/image/original/201508/171345239098.png","inventory":null},{"id":"9c6a5e6e-8c55-4efd-af87-a4ed00ecd300","displayOrder":null,"name":"福特","firstLetter":"F","logoUrl":"http://img.yaomaiche.com/upload/image/original/201508/171343191447.png","inventory":null},{"id":"c4662b2d-5fd5-49ff-96d8-a4ed00ecd301","displayOrder":null,"name":"丰田","firstLetter":"F","logoUrl":"http://img.yaomaiche.com/upload/image/original/201508/171343355492.png","inventory":null},{"id":"6a7a6417-d79a-4b49-9702-a4ed00ecd300","displayOrder":null,"name":"海马","firstLetter":"H","logoUrl":"http://img.yaomaiche.com/upload/image/original/201508/201955099659.png","inventory":null},{"id":"40972dd7-8bc8-4e2d-ac28-a4f800e90352","displayOrder":null,"name":"哈弗","firstLetter":"H","logoUrl":"http://img.yaomaiche.com/upload/image/original/201510/222107309905.png","inventory":null},{"id":"ea4e546f-ae7a-4985-a569-a4ed00ecd301","displayOrder":null,"name":"Jeep","firstLetter":"J","logoUrl":"http://img.yaomaiche.com/upload/image/original/201508/171340359483.png","inventory":null},{"id":"40959312-09ad-417c-a6e6-a4ed00ecd301","displayOrder":null,"name":"捷豹","firstLetter":"J","logoUrl":"http://img.yaomaiche.com/upload/image/original/201508/201509097766.png","inventory":null},{"id":"e8ad6a76-6b46-424d-8a4c-a4ed00ecd301","displayOrder":null,"name":"凯迪拉克","firstLetter":"K","logoUrl":"http://img.yaomaiche.com/upload/image/original/201508/171344195331.png","inventory":null},{"id":"a3799592-dad6-4dbd-a0d1-a4ed00ecd2fc","displayOrder":null,"name":"铃木","firstLetter":"L","logoUrl":"http://img.yaomaiche.com/upload/image/original/201508/201510151504.png","inventory":null},{"id":"84520b13-d924-423e-9bf5-a4ed00ecd301","displayOrder":null,"name":"雷克萨斯","firstLetter":"L","logoUrl":"http://img.yaomaiche.com/upload/image/original/201508/201956143927.png","inventory":null},{"id":"16ee4aec-567d-41b1-8cac-a4ed00ecd303","displayOrder":null,"name":"路虎","firstLetter":"L","logoUrl":"http://img.yaomaiche.com/upload/image/original/201509/250937266327.png","inventory":null},{"id":"c5db8daa-cb88-452f-a330-a4ed00ecd303","displayOrder":null,"name":"路虎","firstLetter":"L","logoUrl":"http://img.yaomaiche.com/upload/image/original/201508/201510491105.png","inventory":null},{"id":"674d9c0e-acd4-4dbd-87fe-a4ed00ecd300","displayOrder":null,"name":"马自达","firstLetter":"M","logoUrl":"http://img.yaomaiche.com/upload/image/original/201508/171344301466.png","inventory":null},{"id":"1c9cb940-76e4-4e68-8c19-a4ed00ecd300","displayOrder":null,"name":"奇瑞","firstLetter":"Q","logoUrl":"http://img.yaomaiche.com/upload/image/original/201508/201956478573.png","inventory":null},{"id":"5926a54f-3cee-414f-93b3-a4ed00ecd300","displayOrder":null,"name":"起亚","firstLetter":"Q","logoUrl":"http://img.yaomaiche.com/upload/image/original/201508/171344449083.png","inventory":null},{"id":"a0b504dd-4b1e-450f-9e11-a4ed00ecd300","displayOrder":null,"name":"日产","firstLetter":"R","logoUrl":"http://img.yaomaiche.com/upload/image/original/201508/171345113964.png","inventory":null},{"id":"688c1e62-9733-4b8a-9f4b-a4ed00ecd301","displayOrder":null,"name":"斯柯达","firstLetter":"S","logoUrl":"http://img.yaomaiche.com/upload/image/original/201508/171345364203.png","inventory":null},{"id":"3aecf484-d914-4279-a9f8-a4ed00ecd301","displayOrder":null,"name":"斯巴鲁","firstLetter":"S","logoUrl":"http://img.yaomaiche.com/upload/image/original/201508/201512125601.png","inventory":null},{"id":"36bbc26c-cb19-439e-a1da-a4ed00ecd303","displayOrder":null,"name":"沃尔沃","firstLetter":"W","logoUrl":"http://img.yaomaiche.com/upload/image/original/201508/171345505736.png","inventory":null},{"id":"f1081335-9341-4a8c-844c-a4ed00ecd300","displayOrder":null,"name":"雪佛兰","firstLetter":"X","logoUrl":"http://img.yaomaiche.com/upload/image/original/201508/171346171872.png","inventory":null},{"id":"53086800-aca0-49e6-a8ec-a4ed00ecd300","displayOrder":null,"name":"现代","firstLetter":"X","logoUrl":"http://img.yaomaiche.com/upload/image/original/201508/171346035511.png","inventory":null},{"id":"a09ace3b-1535-4857-bf46-a4ed00ecd300","displayOrder":null,"name":"雪铁龙","firstLetter":"X","logoUrl":"http://img.yaomaiche.com/upload/image/original/201508/201957134769.png","inventory":null},{"id":"a209f874-c1ea-46fb-9ca4-a4ed00ecd301","displayOrder":null,"name":"英菲尼迪","firstLetter":"Y","logoUrl":"http://img.yaomaiche.com/upload/image/original/201508/171346304533.png","inventory":null},{"id":"aaed3484-a1ba-4ab3-8c4e-a4eb0145bac0","displayOrder":null,"name":"其他","firstLetter":"#","logoUrl":null,"inventory":null}]
     */

    private int carBrandListVersion;
    /**
     * id : 2a88eafe-b977-48a7-af58-a4ed00ecd300
     * displayOrder : null
     * name : 奥迪
     * firstLetter : A
     * logoUrl : http://img.yaomaiche.com/upload/image/original/201508/171340516914.png
     * inventory : null
     */

    private List<SortModel> carBrandList;

    public int getCarBrandListVersion() {
        return carBrandListVersion;
    }

    public void setCarBrandListVersion(int carBrandListVersion) {
        this.carBrandListVersion = carBrandListVersion;
    }

    public List<SortModel> getCarBrandList() {
        return carBrandList;
    }

    public void setCarBrandList(List<SortModel> carBrandList) {
        this.carBrandList = carBrandList;
    }
}
