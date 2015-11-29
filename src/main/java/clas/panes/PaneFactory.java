package src.main.java.clas.panes;

import java.util.ArrayList;
import java.util.HashMap;

import src.main.java.clas.panes.organization.PaneOrgAdd;
import src.main.java.clas.panes.organization.PaneOrgEdit;
import src.main.java.clas.panes.organization.PaneOrgReport;

public class PaneFactory {

	private PaneUI orgAddPane = null;
	private PaneUI orgEditPane = null;
	private PaneUI orgUpdatePane = null;
	private PaneUI orgReportPane = null;
	private HashMap<String, PaneUI> paneMap = new HashMap<>();

	/*private PaneUI deptAddPane = null;
	private PaneUI deptEditPane = null;
	private PaneUI deptUpdatePane = null;
	private PaneUI cityAddPane = null;
	private PaneUI cityEditPane = null;
	private PaneUI cityUpdatePane = null;
	private PaneUI stateAddPane = null;
	private PaneUI stateEditPane = null;
	private PaneUI stateUpdatePane = null;
	private PaneUI countryAddPane = null;
	private PaneUI countryEditPane = null;
	private PaneUI countryUpdatePane = null;
	private PaneOrgQuesAdd quesAddPane;
	private PaneOrgQuesEdit quesEditPane;
	private PaneOrgQuesUpdate quesUpdatePane;
	private PaneOrgRulesAdd rulesAddPane = new PaneOrgRulesAdd();
	private PaneOrgRulesEdit rulesEditPane = new PaneOrgRulesEdit();
	private PaneOrgRulesUpdate rulesUpdatePane = new PaneOrgRulesUpdate(org);
	private PaneOrgSResponseAdd sResAddPane = new PaneOrgSResponseAdd();
	private PaneOrgSResponseEdit sResEditPane = new PaneOrgSResponseEdit();
	private PaneOrgSResponseUpdate sResUpdatePane = new PaneOrgSResponseUpdate(org);
	private PaneOrgQResponseAdd qResAddPane = new PaneOrgQResponseAdd();
	private PaneOrgQResponseEdit qResEditPane = new PaneOrgQResponseEdit();
	private PaneOrgQResponseUpdate qResUpdatePane = new PaneOrgQResponseUpdate(org);
	private PaneOrgSAnalysisAdd sAnAddPane = new PaneOrgSAnalysisAdd();
	private PaneOrgSAnalysisEdit sAnEditPane = new PaneOrgSAnalysisEdit();
	private PaneOrgSAnalysisUpdate sAnUpdatePane = new PaneOrgSAnalysisUpdate(org);
	private PaneOrgQAnalysisAdd qAnAddPane = new PaneOrgQAnalysisAdd();
	private PaneOrgQAnalysisEdit qAnEditPane = new PaneOrgQAnalysisEdit();
	private PaneOrgQAnalysisUpdate qAnUpdatePane = new PaneOrgQAnalysisUpdate(org);
	*/
	
	
	public PaneFactory() {}

	public HashMap<String, PaneUI> initializePanes() {
		
		if (orgAddPane==null){
			orgAddPane = new PaneOrgAdd();
			paneMap.put(PaneOrgAdd.getTitle(), orgAddPane);
		}
		
		if (orgEditPane==null){
			orgEditPane = new PaneOrgEdit();
			paneMap.put(PaneOrgEdit.getTitle(), orgEditPane);
		}
		
		if (orgReportPane==null){
			orgReportPane = new PaneOrgReport();
			paneMap.put(PaneOrgReport.getTitle(), orgReportPane);
		}
		//  orgUpdatePane = new PaneOrgUpdate(org);

		/*deptAddPane = new PaneDeptAdd();
		 deptEditPane = new PaneDeptEdit();
		 deptUpdatePane = new PaneDeptUpdate();
		 cityAddPane = new PaneCityAdd();
		 cityEditPane = new PaneCityEdit();
		 cityUpdatePane = new PaneCityUpdate();
		 stateAddPane = new PaneStateAdd();
		 stateEditPane = new PaneStateEdit();
		 stateUpdatePane = new PaneStateUpdate();
		 countryAddPane = new PaneCountryAdd();
		 countryEditPane = new PaneCountryEdit();
		 countryUpdatePane = new PaneCountryUpdate();
		 quesAddPane = new PaneOrgQuesAdd();
		 quesEditPane = new PaneOrgQuesEdit();
		 quesUpdatePane = new PaneOrgQuesUpdate();
		 /*rulesAddPane = new PaneOrgRulesAdd();
		 rulesEditPane = new PaneOrgRulesEdit();
		 rulesUpdatePane = new PaneOrgRulesUpdate();
		 sResAddPane = new PaneOrgSResponseAdd();
		 sResEditPane = new PaneOrgSResponseEdit();
		 sResUpdatePane = new PaneOrgSResponseUpdate();
		 qResAddPane = new PaneOrgQResponseAdd();
		 qResEditPane = new PaneOrgQResponseEdit();
		 qResUpdatePane = new PaneOrgQResponseUpdate();
		 sAnAddPane = new PaneOrgSAnalysisAdd();
		 sAnEditPane = new PaneOrgSAnalysisEdit();
		 sAnUpdatePane = new PaneOrgSAnalysisUpdate();
		 qAnAddPane = new PaneOrgQAnalysisAdd();
		 qAnEditPane = new PaneOrgQAnalysisEdit();
		 qAnUpdatePane = new PaneOrgQAnalysisUpdate();
		 */
		
		return paneMap;
	}
}
