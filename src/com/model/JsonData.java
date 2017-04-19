package com.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonData {

@SerializedName("MedlineCitationSet")
@Expose
private MedlineCitationSet medlineCitationSet;

public MedlineCitationSet getMedlineCitationSet() {
return medlineCitationSet;
}

public void setMedlineCitationSet(MedlineCitationSet medlineCitationSet) {
this.medlineCitationSet = medlineCitationSet;
}

}