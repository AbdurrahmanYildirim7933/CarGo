package com.mantis.data.dto;

import jakarta.persistence.Query;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

public class ShopFilterDTO {
    private Integer id;

    private String name;

    private String address;

    private String phone;
    private String owner;

    private Map<String,Object> params;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }


    private String getQuery() {
        String query = "";        this.params = new HashMap();
        if (!ObjectUtils.isEmpty(getName())) {
            query += " AND s.name ILIKE :name";
            params.put("name","%"+name+"%");
        }

        if (!ObjectUtils.isEmpty(getAddress())) {
            query += " AND s.address ILIKE :address";
            params.put("address","%"+address+"%");
        }

        if (!ObjectUtils.isEmpty(getOwner())) {
            query += " AND s.owner ILIKE :owner";

        }
        return query;
    }

    public String getResultQuery(){
        return "SELECT * FROM tbl_shop as s WHERE 1=1  "+getQuery();
    }
    public String getCountQuery(){
        return "SELECT count(*) FROM tbl_shop as s WHERE 1=1 "+getQuery();
    }

    public Query getResultQ(Query q){
       if(!ObjectUtils.isEmpty(this.params)){
           params.keySet().forEach(k->{
            q.setParameter(k,params.get(k));
           });
       }


        return q;
    }


}
  /*  String query="SELECT * FROM tbl_shop WHERE 1=1 ";

    public String getQuery(){
        if(!ObjectUtils.isEmpty(getName())){
            query+=" AND name ilike 'ankara' ";
        }
        return query;

    }*/


/*  @Autowired EntityManager em;
    public List<Shop> searchShopByTerm(Shop shop) {
        String where = " 1=1 ";

        if (!ObjectUtils.isEmpty(shop.getAddress())){
            where +=" s.address ilike :adress ";
        }
        String sqlQuery= "select * from tbl_shop s where s.name ilike :shop" +
                " OR s.address ilike :shop OR s.owner ilike :shop";
        return em.createNativeQuery(sqlQuery, Shop.class)
                .setParameter("shop", shop.getName())
                .getResultList();
    }
}
*/




