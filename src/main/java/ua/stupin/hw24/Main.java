package ua.stupin.hw24;

import org.hibernate.Session;

import org.hibernate.query.Query;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int deviceID = 2;
        int deviceIDForUpdate = 4;
        int factoryId = 1;
        int deviceIdForDelete = 2;
        createTableDeviceAndFactoryAndFillThem();
//        Information about device
        System.out.println(getDeviceById(deviceID));
        updateDevice(deviceIDForUpdate, getDeviceById(deviceID).get(0));
        deleteDevice(deviceIdForDelete);
        getAllDevicesCreatedInFactory(factoryId);
        getQuantityOfTypeAndSumOfDevicesPriceFromEachFactory(factoryId);
    }

    private static List<Object[]> getQuantityOfTypeAndSumOfDevicesPriceFromEachFactory(int factoryId) {
        List<Object[]> list = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("select factory.name, count(device), sum(device.price) " +
                    "from Device device INNER JOIN device.factory factory group by device.factoryID");
            list = query.list();
            System.out.println("device: factory name//" + "quantity devices//" + "sum of prices)");
            for (Object[] arr : list) {
                System.out.println(Arrays.toString(arr));
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return list;
    }

    private static Query updateDevice(int deviceID, Device device) {
        Session session = null;
        Query query = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            query = session.createQuery("UPDATE Device SET " +
                    "type =:type, " +
                    "modelName =:modelName, " +
                    "price =:price, " +
                    "creationDate =:creationDate, " +
                    "description =:description, " +
                    "availabilityInWarehouse =:availabilityInWarehouse, " +
                    "factoryID =:factoryID " +
                    "WHERE id =:id");
            query.setParameter("type", device.getType());
            query.setParameter("modelName", device.getModelName());
            query.setParameter("price", device.getPrice());
            query.setParameter("creationDate", device.getCreationDate());
            query.setParameter("description", device.getDescription());
            query.setParameter("availabilityInWarehouse", device.isAvailabilityInWarehouse());
            query.setParameter("factoryID", device.getFactoryID());
            query.setParameter("id", deviceID);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return query;
    }

    private static List<Object[]> getAllDevicesCreatedInFactory(int factoryId) {
        Query query = null;
        List<Object[]> list = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            query = session.createQuery("select device.id, device.type, device.modelName, device.price, " +
                    "device.creationDate, device.description, device.availabilityInWarehouse, device.factoryID," +
                    "factory.name from Device device " +
                    "INNER JOIN device.factory factory where factory.id like " + factoryId);
            list = query.list();
            System.out.println("device: id//" + "type//" + "modelName//" + "price//" +
                    "creationDate//" + "description//" + "availabilityInWarehouse//" +
                    "factoryID//" + "factory.name");
            for (Object[] arr : list) {
                System.out.println(Arrays.toString(arr));
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return list;
    }

    private static Query deleteDevice(int deviceID) {
        Query query = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            query = session.createQuery("delete from Device WHERE id =:id");
            query.setParameter("id", deviceID);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return query;
    }

    private static void createTableDeviceAndFactoryAndFillThem() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            for (int i = 0; i < getFactoryList().size(); i++) {
                session.save(getFactoryList().get(i));
            }
            for (int i = 0; i < getDeviceList().size(); i++) {
                session.save(getDeviceList().get(i));
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    private static List<Device> getDeviceById(int id) {
        Session session = null;
        List<Device> result = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createSQLQuery("SELECT * FROM device where id like :id").addEntity(Device.class);
            result = query.setParameter("id", id).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    public static Date stringToDate(String s) {
        Date result = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            result = dateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<Device> getDeviceList() {
        Device device1 = new Device();
        Device device2 = new Device();
        Device device3 = new Device();
        Device device4 = new Device();
        Device device5 = new Device();
        Device device6 = new Device();
        Device device7 = new Device();
        Device device8 = new Device();
        Device device9 = new Device();
        Device device10 = new Device();
        device1.setType("phone");
        device1.setModelName("S1");
        device1.setPrice(200);
        device1.setCreationDate(stringToDate("2022-07-01"));
        device1.setDescription("no text");
        device1.setAvailabilityInWarehouse(true);
        device1.setFactoryID(1);

        device2.setType("phone");
        device2.setModelName("S2");
        device2.setPrice(400);
        device2.setCreationDate(stringToDate("2022-07-02"));
        device2.setDescription("no text");
        device2.setAvailabilityInWarehouse(true);
        device2.setFactoryID(1);

        device3.setType("notebook");
        device3.setModelName("a550");
        device3.setPrice(1200);
        device3.setCreationDate(stringToDate("2022-07-02"));
        device3.setDescription("no text");
        device3.setAvailabilityInWarehouse(true);
        device3.setFactoryID(1);

        device4.setType("chair");
        device4.setModelName("red wood");
        device4.setPrice(75);
        device4.setCreationDate(stringToDate("2021-04-19"));
        device4.setDescription("no text");
        device4.setAvailabilityInWarehouse(true);
        device4.setFactoryID(2);

        device5.setType("bookcase");
        device5.setModelName("white wood");
        device5.setPrice(90);
        device5.setCreationDate(stringToDate("2000-01-02"));
        device5.setDescription("no text");
        device5.setAvailabilityInWarehouse(false);
        device5.setFactoryID(2);

        device6.setType("engine");
        device6.setModelName("XV-40");
        device6.setPrice(15000);
        device6.setCreationDate(stringToDate("2022-11-24"));
        device6.setDescription("no text");
        device6.setAvailabilityInWarehouse(true);
        device6.setFactoryID(3);

        device7.setType("shirt");
        device7.setModelName("cotton");
        device7.setPrice(10);
        device7.setCreationDate(stringToDate("2022-09-11"));
        device7.setDescription("no text");
        device7.setAvailabilityInWarehouse(true);
        device7.setFactoryID(4);

        device8.setType("pants");
        device8.setModelName("jeans");
        device8.setPrice(50);
        device8.setCreationDate(stringToDate("2022-09-11"));
        device8.setDescription("no text");
        device8.setAvailabilityInWarehouse(true);
        device8.setFactoryID(4);

        device9.setType("dress");
        device9.setModelName("georgette");
        device9.setPrice(100);
        device9.setCreationDate(stringToDate("2022-09-11"));
        device9.setDescription("no text");
        device9.setAvailabilityInWarehouse(true);
        device9.setFactoryID(4);

        device10.setType("sweater");
        device10.setModelName("polyester");
        device10.setPrice(20);
        device10.setCreationDate(stringToDate("2022-01-12"));
        device10.setDescription("no text");
        device10.setAvailabilityInWarehouse(false);
        device10.setFactoryID(4);

        List<Device> deviceList = new ArrayList<>();
        deviceList.add(device1);
        deviceList.add(device2);
        deviceList.add(device3);
        deviceList.add(device4);
        deviceList.add(device5);
        deviceList.add(device6);
        deviceList.add(device7);
        deviceList.add(device8);
        deviceList.add(device9);
        deviceList.add(device10);
        return deviceList;
    }

    public static List<Factory> getFactoryList() {
        Factory factory1 = new Factory();
        Factory factory2 = new Factory();
        Factory factory3 = new Factory();
        Factory factory4 = new Factory();

        factory1.setCountry("Japan");
        factory1.setName("electronic production");

        factory2.setCountry("Ukraine");
        factory2.setName("furniture production");

        factory3.setCountry("Germany");
        factory3.setName("engine production");

        factory4.setCountry("Poland");
        factory4.setName("clothes production");

        List<Factory> factoryList = new ArrayList<>();
        factoryList.add(factory1);
        factoryList.add(factory2);
        factoryList.add(factory3);
        factoryList.add(factory4);
        return factoryList;
    }
}
