package com.mmm.mas.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

public class Shp2Json {

	public static void main(String[] args) {
		Shp2Json s = new Shp2Json();
		
		s.Shp2Echarts("C:\\Users\\ZHANGJX\\Desktop\\中煤\\fits\\json\\1old.json", "C:\\Users\\ZHANGJX\\Desktop\\中煤\\fits\\json\\1tran.json");
		
	}

	public void Shp2Echarts(String file, String tranFile) {
		String sb = getShpFile(file);
		JSONObject jb = JSONObject.parseObject(sb);

		EchartsJson echartsJson = new EchartsJson();
		List<Features> list = new ArrayList<Features>();
		for (Object oKey : jb.keySet()) {
			if ("geometries".equals(oKey)) {
				JSONArray jbArray = (JSONArray) jb.get(oKey);
				for (Object jboKey : jbArray) {// Features
					Features features = new Features();
					JSONObject coordJson = (JSONObject) jboKey;
					for (Object coordStr : coordJson.keySet()) {
						if ("coordinates".equals(coordStr)) {// coordinates
							JSONArray ja = new JSONArray();
							JSONArray res = (JSONArray) coordJson.get(coordStr);
							ja.add(res);
							Geometry geometry = new Geometry(ja);
							features.setGeometry(geometry);
						}
					}
					list.add(features);
				}
			}
		}
		echartsJson.setFeatures(list);
		Object jo = JSON.toJSONString(echartsJson);
		System.out.println(jo);
		
		writeFile(jo.toString(), tranFile);
		
		System.out.println("-- end --");
	}
	
	private String getShpFile(String file) {
		BufferedReader reader = null;
		StringBuffer sb = new StringBuffer();
		try {
			reader = new BufferedReader(new FileReader(new File(file)));
			String temp = "";
			while ((temp = reader.readLine()) != null) {
				sb.append(temp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return sb.toString();
	}

	private void writeFile(String str, String file) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
			out.write(str);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}


class EchartsJson {
	@JSONField(ordinal = 0)
	private String type;
	@JSONField(ordinal = 2)
	private List<Features> features;

	public EchartsJson() {
		super();
		this.type = "FeatureCollection";
	}

	public EchartsJson(List<Features> features) {
		super();
		this.type = "FeatureCollection";
		this.features = features;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Features> getFeatures() {
		return features;
	}

	public void setFeatures(List<Features> features) {
		this.features = features;
	}

	@Override
	public String toString() {
		return "EchartsJson [type=" + type + ", features=" + features.toString() + "]";
	}

}

class Features {
	@JSONField(ordinal = 0)
	private String type;
	@JSONField(ordinal = 1)
	private JSONObject properties;
	@JSONField(ordinal = 2)
	private Geometry geometry;

	public Features() {
		super();
		this.type = "Feature";
		this.properties = new JSONObject();
	}

	public Features(Geometry geometry) {
		super();
		this.type = "Feature";
		this.properties = new JSONObject();
		this.geometry = geometry;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public JSONObject getProperties() {
		return properties;
	}

	public void setProperties(JSONObject properties) {
		this.properties = properties;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	@Override
	public String toString() {
		return "Features [type=" + type + ", properties=" + properties + ", geometry=" + geometry.toString() + "]";
	}

}

class Geometry {
	@JSONField(ordinal = 0)
	private String type;
	@JSONField(ordinal = 1)
	private JSONArray coordinates;

	public Geometry(JSONArray coordinates) {
		super();
		this.type = "Polygon";
		this.coordinates = coordinates;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public JSONArray getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(JSONArray coordinates) {
		this.coordinates = coordinates;
	}

	@Override
	public String toString() {
		return "Geometry [type=" + type + ", coordinates=" + coordinates + "]";
	}
}