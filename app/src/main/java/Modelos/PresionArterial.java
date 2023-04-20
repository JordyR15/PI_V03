package Modelos;

import org.json.JSONException;
import org.json.JSONObject;

public class PresionArterial {
    private JSONObject limites;

    public PresionArterial() {
        limites = new JSONObject();
        try {
            limites.put("mm_Hg", "Milímetros de mercurio");
            limites.put("pr_art_norm_hg", 80);
            limites.put("pr_art_norm_lw", 120);
            limites.put("pr_art_alta_sistolica", 121);
            limites.put("pr_art_baja_distolica", 80);
            limites.put("hiper1_sistolica_min", 130);
            limites.put("hiper1_sistolica_max", 139);
            limites.put("hiper1_distolica_min", 80);
            limites.put("hiper1_distolica_max", 89);
            limites.put("hiper2_sistolica_min", 140);
            limites.put("hiper2_sistolica_max", 179);
            limites.put("hiper2_distolica_min", 90);
            limites.put("hiper2_distolica_max", 120);
            limites.put("crisis_hiper_sistolica", 180);
            limites.put("crisis_hiper_distolica", 120);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getLimite(String limite) {
        int valor = 0;
        try {
            valor = limites.getInt(limite);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return valor;
    }
}

/*
* llamado
    PresionArterial presionArterial = new PresionArterial();
    int limiteSistolicoMinHiper1 = presionArterial.getLimite("hiper1_sistolica_min");
    int limiteDiastolicoMaxHiper2 = presionArterial.getLimite("hiper2_distolica_max");
* */
