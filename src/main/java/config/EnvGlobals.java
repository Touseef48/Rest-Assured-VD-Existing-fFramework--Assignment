/*
Define global variables to use re-use them
 */

package config;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EnvGlobals {


    public static StringBuilder Differnce = new StringBuilder() ;


    public static Response response; // API response object
    public static RequestSpecification requestSpecification; // given store object
    public static String basicAccessToken = "Basic cHVibGljOnB1YmxpYw==";
    public static String appbasicToken = "Basic bW9iaWxlLWFwcDpkYjUwNjk2YS03MjViLTExZWEtYmM1NS0wMjQyYWMxMzAwMDM=";
    public static String authorizationToken; // authorization key with bearer
    public  static  String accessTokenforchangePIN; //use for generate PIN
    public static String JobuserId; //user Id to get jobs
    public static String updateEpcAssetId ;
    public static String updateEnpAssetId ;
    public static String siteID = "36";
    public static String EmailuserId;
    public static String emailPrincipleName;
    public static String PhoneprincipleName;
    public static String updatephoneuserResponse;
    public static String updateEmailuserResponse;



    public static String PhoneuserId;

    public static String userId;
    public static String projectuserId2;

    public static String userName;
    public static String latestSiteId;
    public static String epcDnowNumber;
    public static String enpDnowNumber;
    public static String enpDnowNo;
    public static String epcDnowNo;
    public static String updateProjectId ;
    public static String updateMilestoneId = "43";
    public static String defectiveAssetID = "168";
    public static String updateDocId;
    public static String updateDocumentId;
    public static String updateEnpDataSheetId;
    public static String planRepairData;
    public static String receivingAssetData;
    public static String pretestAssetData;
    public static String PretestTechInputAssetData;
    public static String RepairAssetData;
    public static String updateValveDataSheetId;
    public static String valveAssetID;
    public static String projectjobID;
    public static String unassociatedAssetID;
    public static String updateFlangeDataSheetId;
    public static String flangeAssetID;
    public static String unassociatedFlangeAssetID;
    public static String flangeJobID;
    public static String defectiveAssetFlangeID="173";
    public static String unapprovedId;
    public static String latestFieldId;
    public static String latestFieldId1;

    public static String FieldLocationName;

    public static String mileStoneId;



    public static String customerId;
    public static String customerName;
    public static String vendorId;
    public static String vendorName;
    public static String roleId;
    public static String roleATitle;
    public static String OpJobId;
    public static String OpJobIdForDelete;
    public static String projectJobIdForDelete;

    public static String OpJobIdforUnassociate;
    public static String projectJobIdforUnassociate;
    public static int pagesize;


    public static String ReassemblyAssetData;
    public static String FinalTestTechAssetData;
    public static String FinalTestEngAssetData;

    public static String FinalInspectionAssetData;
    public static String unapprovedEnpDataSheetId;
    public static String updateEpcDataSheetId = "158";
    public static String unapprovedEpcDataSheetId;
    public static String enpDataRecordId;
    public static String epcDataRecordId;
    public static String databaseName= "tvs";
    public static String enpMasterDbValues ="ma20,actuated_manual,anti_static,area,astm_asmeb1634,backseat,ball_position_indicator,blow_out_proof_stem,body_design,body_material,bolt_coating,bolt_length,bolt_quantity,bolt_size,bolting_material,bom,bonnet_design,bore_size,bore_type,certified_length_mm,client_joint_id,country,criticality,customer,dbb_feature,design_temperature_max,design_temperature_min,dnow_joint_id,dnow_project_no,dnow_valve_no,drain_plug,en1020431,en1020432,end_connection1,end_connection2,epc_name,equipment_number,extension_height,f_tofdimension,fail_position,sheet_field_location,firesafe_seals,flange_size,flange_standard,flange_type,flow_direction,fluid_code,functional_location,ga_drawing,gasket_material,gasket_type,gaskets,hp_pneumatic,hydrostatic,indicator_manufacturer,indicator_model,indicator_type,inspection_interval,installation_date,insulation,iso_failure_mode1,iso_failure_mode2,iso_failure_mode3,lp_pneumatic,last_certification_date,line_iso_number,lockable_device,long_text_description,lpi,lubricant_cof,lubricant_required,manual_overide_fitted,module,mpi,mtbf_months,nace_mr0103,nace_mr0175,nde,next_certification_date,nps1,nps2,obturator_design,obturator_material,oem_material_number,operating_Temperature_max,operating_Temperature_min,operation,operator_description,operator_manufacturer,operator_model,operator_serial_number,operator_type,overlay_on_body,overlay_material,packing,paint_code,paint_spec,pattern,pid,pipe_material,pipe_size,pipe_spec,plug_characteristic,pmi,po_number,position_indicator,positioner_action,positioner_fitted,positioner_manufacturer,positioner_model,positioner_serial_number,positioner_type,pressure_balanced,pressure_rating_flange,pressure_rating_nps1,pressure_rating_nps2,primary_seal_material,primary_seal_type,priority_level,qty,rt,recommended_air_supply_range,recommended_torque_method,repair_date1,repair_date2,repair_date3,required_tension_tool_pressure,required_closing_time,required_opening_time,required_torque_tool_pressure100,required_torque_tool_pressure30,required_torque_tool_pressure60,required_torque_value100,required_torque_value30,required_torque_value60,sales_order,seat_design,seat_injection_port,seat_insert_material,seat_ring_material,seat_spring,service,shaft_is,short_text_description,shutoff_class,signal_range,signal_type,site,site_record_number,stem_trunnion_material,stem_extension,stem_injection_port,stud_nut_material,sub_system_no,supply_pressure,system_no,tensioning_coverage,test_pack_no,tool_pump_reference,torque,travel,trim,trim_size_number,ut,valve_brand,valve_cv,valve_data_sheet,valve_manufacture_date,valve_manufacturer,valve_model,valve_serial_number,valve_sub_type,valve_tag_no,valve_testing_standard,valve_type,vent_plug,warranty_expiry_date";
    public static String epcMasterDbValues = "ma20,actuated_manual,anti_static,area,astm_asmeb1634,backseat,ball_position_indicator,blow_out_proof_stem,body_design,body_material,bolt_coating,bolt_length,bolt_quantity,bolt_size,bolting_material,bom,bonnet_design,bore_size,bore_type,certified_length_mm,client_joint_id,country,criticality,customer,dbb_feature,design_temperature_max,design_temperature_min,dnow_joint_id,dnow_project_no,dnow_valve_no,drain_plug,en1020431,en1020432,end_connection1,end_connection2,epc_name,equipment_number,extension_height,f_tofdimension,fail_position,sheet_field_location,firesafe_seals,flange_size,flange_standard,flange_type,flow_direction,fluid_code,functional_location,ga_drawing,gasket_material,gasket_type,gaskets,hp_pneumatic,hydrostatic,indicator_manufacturer,indicator_model,indicator_type,inspection_interval,installation_date,insulation,iso_failure_mode1,iso_failure_mode2,iso_failure_mode3,lp_pneumatic,last_certification_date,line_iso_number,lockable_device,long_text_description,lpi,lubricant_cof,lubricant_required,manual_overide_fitted,module,mpi,mtbf_months,nace_mr0103,nace_mr0175,nde,next_certification_date,nps,nps1,nps2,obturator_design,obturator_material,oem_material_number,operating_Temperature_max,operating_Temperature_min,operation,operator_description,operator_manufacturer,operator_model,operator_serial_number,operator_type,overlay_on_body,overlay_material,packing,paint_code,paint_spec,pattern,pid,pipe_material,pipe_size,pipe_spec,plug_characteristic,pmi,po_number,position_indicator,positioner_action,positioner_fitted,positioner_manufacturer,positioner_model,positioner_serial_number,positioner_type,pressure_balanced,pressure_rating_flange,pressure_rating_nps1,pressure_rating_nps2,primary_seal_material,primary_seal_type,priority_level,qty,rt,recommended_air_supply_range,recommended_tightening_tool,recommended_torque_method,repair_date1,repair_date2,repair_date3,required_tension_tool_pressure,required_tension_tool_pressure_one,required_tension_tool_pressure_two,required_tension_tool_pressure_three,required_tension_tool_pressure_four,required_closing_time,required_opening_time,required_torque_tool_pressure_hundred,required_torque_tool_pressure_thirty,required_torque_tool_pressure_sixty,required_torque_value_hundred,required_torque_value_thirty,required_torque_value_sixty,sales_order,seat_design,seat_injection_port,seat_insert_material,seat_ring_material,seat_spring,service,shaft_is,short_text_description,shutoff_class,signal_range,signal_type,site,site_record_number,stem_trunnion_material,stem_extension,stem_injection_port,stud_length,stud_quantity,stud_size,stud_nut_material,sub_system_no,supply_pressure,system_no,tensioning_coverage,test_pack_no,tool_pump_reference,torque,travel,trim,trim_size_number,ut,valve_brand,valve_cv,valve_data_sheet,valve_manufacture_date,valve_manufacturer,valve_model,valve_serial_number,valve_sub_type,valve_tag_no,valve_testing_standard,valve_type,vent_plug,warranty_expiry_date";

    public static String enpInventoryValues = "actuated_manual,anti_static,ball_position_indicator,body_design,body_material,bore_size,bore_type,country,customer,customer_material_number,design_temperature_max,design_temperature_min,drain_plug,end_connection1,end_connection2,sheet_field_location,gaskets,seat_injection_port,lockable_device,long_text_description,material_group_code,nps1,nps2,obturator_design,obturator_material,oem_material_number,operating_Temperature_max,operating_Temperature_min,operator_description,operator_manufacturer,operator_model,operator_serial_number,operator_type,overlay_material,overlay_on_body,packing,pressure_rating_nps1,pressure_rating_nps2,primary_seal_material,primary_seal_type,qty,qty_on_order,recommended_max,recommended_min,seat_design,seat_insert_material,seat_ring_material,short_text_description,site,stem_trunnion_material,stem_extension,stem_injection_port,valve_brand,valve_data_sheet,valve_manufacture_date,valve_manufacturer,valve_model,valve_serial_number,valve_sub_type,valve_type,vent_plug";


    public static String vendorDbColumns = "actuated_manual,anti_static,ball_position_indicator,body_design,body_material,bore_size,bore_type,client_country,country,customer,design_temperature_max,design_temperature_min,drain_plug,end_connection1,end_connection2,epc_name,sheet_field_location,gaskets,industry_type,seat_injection_port,lockable_device,long_text_description,materials,nps1,nps2,obturator_design,obturator_material,oem_material_number,operating_Temperature_max,operating_Temperature_min,operator_description,operator_manufacturer,operator_model,operator_type,overlay_material,overlay_on_body,packing,pressure_rating_nps1,pressure_rating_nps2,primary_seal_material,primary_seal_type,qty,sales_order,seat_design,seat_insert_material,seat_ring_material,service,short_text_description,site,stem_trunnion_material,stem_extension,stem_injection_port,valve_brand,valve_data_sheet,valve_manufacture_date,valve_manufacturer,valve_model,valve_serial_number,valve_sub_type,valve_tag_no,valve_type,vent_plug";
}
