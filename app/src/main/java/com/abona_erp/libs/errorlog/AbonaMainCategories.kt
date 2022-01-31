package com.abona_erp.libs.errorlog

/**
 * Created on 06.01.2022 by Anton Kogan. Email: akogan777@gmail.com.
 */
enum class AbonaMainCategories(category: Int, description: String) {
    General(0, "AbonaMainCategories_General"),
    CRM_DMS(1, "AbonaMainCategories_CRM_DMS"),
    BusinessIntelligence(2, "AbonaMainCategories_BI"),
    Customers(3, "AbonaMainCategories_Customers"),
    Suppliers(4, "AbonaMainCategories_Suppliers"),
    Articles(5, "AbonaMainCategories_Articles"),
    CashRegister(6, "AbonaMainCategories_CashRegister"),
    Orders(7, "AbonaMainCategories_Orders"),
    PurchaseOrders(8, "AbonaMainCategories_PurchaseOrders"),
    OpenItems(9, "AbonaMainCategories_PurchaseOrders"),
    Accounting(10, "AbonaMainCategories_PurchaseOrders"),
    Logistics(11, "AbonaMainCategories_PurchaseOrders"),
    Controlling(12, "AbonaMainCategories_PurchaseOrders"),
    DataMaintenance(13, "AbonaMainCategories_PurchaseOrders"),
    Administration(14, "AbonaMainCategories_PurchaseOrders"),
    Modules(15, "AbonaMainCategories_PurchaseOrders"),
    AutomationServer(16, "AbonaMainCategories_PurchaseOrders"),
    Interfaces(17, "AbonaMainCategories_PurchaseOrders"),
    Help(18, "AbonaMainCategories_PurchaseOrders"),
    Projects(19, "AbonaMainCategories_Projects"),
    UNKNOWN(1000, "UNKNOWN")
}