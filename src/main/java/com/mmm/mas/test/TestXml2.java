package com.mmm.mas.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import com.alibaba.fastjson.JSONObject;

/**
 * XML解析
 */
public class TestXml2 {
	public static Map<String, String> protoMap = new HashMap<>();
//	private boolean isBody = true;

	public static void main(String[] args) throws Exception {
		String s = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
				"<Protocol id=\"{ee979b9d-a4be-4e64-a90a-2899ef6daaa2}\">\r\n" + 
				"    <Command>\r\n" + 
				"        <baseProtocolInfo>\r\n" + 
				"            <namezh>点迹</namezh>\r\n" + 
				"            <name>dianji</name>\r\n" + 
				"            <type>dianji</type>\r\n" + 
				"            <id>{ee979b9d-a4be-4e64-a90a-2899ef6daaa2}</id>\r\n" + 
				"            <maxOrderNo>11</maxOrderNo>\r\n" + 
				"            <length>50</length>\r\n" + 
				"            <datetime>空</datetime>\r\n" + 
				"            <constraint></constraint>\r\n" + 
				"            <idents/>\r\n" + 
				"        </baseProtocolInfo>\r\n" + 
				"        <setList>\r\n" + 
				"            <set>\r\n" + 
				"                <id>x954f6e7aff434889aec554f4c1181451</id>\r\n" + 
				"                <repeat>1</repeat>\r\n" + 
				"                <orderNo>0</orderNo>\r\n" + 
				"            </set>\r\n" + 
				"            <set>\r\n" + 
				"                <id>xa2f3dc110d3b466883c97c356ec3a77f</id>\r\n" + 
				"                <repeat>1</repeat>\r\n" + 
				"                <orderNo>1</orderNo>\r\n" + 
				"            </set>\r\n" + 
				"            <set>\r\n" + 
				"                <id>x268528ffff284765b9b52ee374a27fa8</id>\r\n" + 
				"                <repeat>1</repeat>\r\n" + 
				"                <orderNo>2</orderNo>\r\n" + 
				"            </set>\r\n" + 
				"        </setList>\r\n" + 
				"        <parent>m_sParentId</parent>\r\n" + 
				"        <children>\r\n" + 
				"            <child>m_sChildrenID</child>\r\n" + 
				"        </children>\r\n" + 
				"        <defaultmsg>b1b10000000000000bb8000003e80bb8000003e8000000000000000000000000000000000000000000000000000000000000</defaultmsg>\r\n" + 
				"    </Command>\r\n" + 
				"    <set id=\"x954f6e7aff434889aec554f4c1181451\">\r\n" + 
				"        <baseInfo>\r\n" + 
				"            <name>head</name>\r\n" + 
				"            <note> </note>\r\n" + 
				"            <type> </type>\r\n" + 
				"            <maxOrderNo>2</maxOrderNo>\r\n" + 
				"            <length>4</length>\r\n" + 
				"            <constraint> </constraint>\r\n" + 
				"            <repeat>1</repeat>\r\n" + 
				"        </baseInfo>\r\n" + 
				"        <fields>\r\n" + 
				"            <field key=\"head\">\r\n" + 
				"                <orderNo>0</orderNo>\r\n" + 
				"                <key>head</key>\r\n" + 
				"                <fieldDescripId> </fieldDescripId>\r\n" + 
				"                <note>报文头</note>\r\n" + 
				"                <fieldType>short</fieldType>\r\n" + 
				"                <size>1</size>\r\n" + 
				"                <bitFilled>0</bitFilled>\r\n" + 
				"                <fieldLength>2</fieldLength>\r\n" + 
				"                <fieldStartByte>0</fieldStartByte>\r\n" + 
				"                <defaultValue>0xb1b1</defaultValue>\r\n" + 
				"                <judge>0</judge>\r\n" + 
				"                <FieldSituationType>0</FieldSituationType>\r\n" + 
				"                <info></info>\r\n" + 
				"            </field>\r\n" + 
				"            <field key=\"long\">\r\n" + 
				"                <orderNo>1</orderNo>\r\n" + 
				"                <key>long</key>\r\n" + 
				"                <fieldDescripId> -long</fieldDescripId>\r\n" + 
				"                <note>数据包长度</note>\r\n" + 
				"                <fieldType>short</fieldType>\r\n" + 
				"                <size>1</size>\r\n" + 
				"                <bitFilled>0</bitFilled>\r\n" + 
				"                <fieldLength>2</fieldLength>\r\n" + 
				"                <fieldStartByte>2</fieldStartByte>\r\n" + 
				"                <defaultValue>0</defaultValue>\r\n" + 
				"                <judge>0</judge>\r\n" + 
				"                <FieldSituationType>0</FieldSituationType>\r\n" + 
				"                <info></info>\r\n" + 
				"            </field>\r\n" + 
				"        </fields>\r\n" + 
				"    </set>\r\n" + 
				"    <set id=\"xa2f3dc110d3b466883c97c356ec3a77f\">\r\n" + 
				"        <baseInfo>\r\n" + 
				"            <name>body</name>\r\n" + 
				"            <note> </note>\r\n" + 
				"            <type> </type>\r\n" + 
				"            <maxOrderNo>20</maxOrderNo>\r\n" + 
				"            <length>44</length>\r\n" + 
				"            <constraint> </constraint>\r\n" + 
				"            <repeat>1</repeat>\r\n" + 
				"        </baseInfo>\r\n" + 
				"        <fields>\r\n" + 
				"            <field key=\"typel\">\r\n" + 
				"                <orderNo>0</orderNo>\r\n" + 
				"                <key>typel</key>\r\n" + 
				"                <fieldDescripId> </fieldDescripId>\r\n" + 
				"                <note>类型码</note>\r\n" + 
				"                <fieldType>char</fieldType>\r\n" + 
				"                <size>1</size>\r\n" + 
				"                <bitFilled>0</bitFilled>\r\n" + 
				"                <fieldLength>1</fieldLength>\r\n" + 
				"                <fieldStartByte>4</fieldStartByte>\r\n" + 
				"                <defaultValue>0</defaultValue>\r\n" + 
				"                <judge>0</judge>\r\n" + 
				"                <FieldSituationType>0</FieldSituationType>\r\n" + 
				"                <info></info>\r\n" + 
				"            </field>\r\n" + 
				"            <field key=\"types\">\r\n" + 
				"                <orderNo>1</orderNo>\r\n" + 
				"                <key>types</key>\r\n" + 
				"                <fieldDescripId> -types</fieldDescripId>\r\n" + 
				"                <note>属性码</note>\r\n" + 
				"                <fieldType>char</fieldType>\r\n" + 
				"                <size>1</size>\r\n" + 
				"                <bitFilled>0</bitFilled>\r\n" + 
				"                <fieldLength>1</fieldLength>\r\n" + 
				"                <fieldStartByte>5</fieldStartByte>\r\n" + 
				"                <defaultValue>0</defaultValue>\r\n" + 
				"                <judge>0</judge>\r\n" + 
				"                <FieldSituationType>0</FieldSituationType>\r\n" + 
				"                <info></info>\r\n" + 
				"            </field>\r\n" + 
				"            <field key=\"ptq\">\r\n" + 
				"                <orderNo>2</orderNo>\r\n" + 
				"                <key>ptq</key>\r\n" + 
				"                <fieldDescripId> -ptq</fieldDescripId>\r\n" + 
				"                <note>点迹质量</note>\r\n" + 
				"                <fieldType>short</fieldType>\r\n" + 
				"                <size>1</size>\r\n" + 
				"                <bitFilled>0</bitFilled>\r\n" + 
				"                <fieldLength>2</fieldLength>\r\n" + 
				"                <fieldStartByte>6</fieldStartByte>\r\n" + 
				"                <defaultValue>0</defaultValue>\r\n" + 
				"                <judge>0</judge>\r\n" + 
				"                <FieldSituationType>0</FieldSituationType>\r\n" + 
				"                <info></info>\r\n" + 
				"            </field>\r\n" + 
				"            <field key=\"orientation\">\r\n" + 
				"                <orderNo>3</orderNo>\r\n" + 
				"                <key>orientation</key>\r\n" + 
				"                <fieldDescripId> -orientation</fieldDescripId>\r\n" + 
				"                <note>方位</note>\r\n" + 
				"                <fieldType>short</fieldType>\r\n" + 
				"                <size>1</size>\r\n" + 
				"                <bitFilled>0</bitFilled>\r\n" + 
				"                <fieldLength>2</fieldLength>\r\n" + 
				"                <fieldStartByte>8</fieldStartByte>\r\n" + 
				"                <defaultValue>3000</defaultValue>\r\n" + 
				"                <judge>0</judge>\r\n" + 
				"                <FieldSituationType>0</FieldSituationType>\r\n" + 
				"                <info></info>\r\n" + 
				"            </field>\r\n" + 
				"            <field key=\"distance\">\r\n" + 
				"                <orderNo>4</orderNo>\r\n" + 
				"                <key>distance</key>\r\n" + 
				"                <fieldDescripId> -distance</fieldDescripId>\r\n" + 
				"                <note>距离</note>\r\n" + 
				"                <fieldType>int</fieldType>\r\n" + 
				"                <size>1</size>\r\n" + 
				"                <bitFilled>0</bitFilled>\r\n" + 
				"                <fieldLength>4</fieldLength>\r\n" + 
				"                <fieldStartByte>10</fieldStartByte>\r\n" + 
				"                <defaultValue>1000</defaultValue>\r\n" + 
				"                <judge>0</judge>\r\n" + 
				"                <FieldSituationType>0</FieldSituationType>\r\n" + 
				"                <info></info>\r\n" + 
				"            </field>\r\n" + 
				"            <field key=\"elevation\">\r\n" + 
				"                <orderNo>5</orderNo>\r\n" + 
				"                <key>elevation</key>\r\n" + 
				"                <fieldDescripId> -elevation</fieldDescripId>\r\n" + 
				"                <note>仰角</note>\r\n" + 
				"                <fieldType>short</fieldType>\r\n" + 
				"                <size>1</size>\r\n" + 
				"                <bitFilled>0</bitFilled>\r\n" + 
				"                <fieldLength>2</fieldLength>\r\n" + 
				"                <fieldStartByte>14</fieldStartByte>\r\n" + 
				"                <defaultValue>3000</defaultValue>\r\n" + 
				"                <judge>0</judge>\r\n" + 
				"                <FieldSituationType>0</FieldSituationType>\r\n" + 
				"                <info></info>\r\n" + 
				"            </field>\r\n" + 
				"            <field key=\"high\">\r\n" + 
				"                <orderNo>6</orderNo>\r\n" + 
				"                <key>high</key>\r\n" + 
				"                <fieldDescripId> -high</fieldDescripId>\r\n" + 
				"                <note>高度</note>\r\n" + 
				"                <fieldType>int</fieldType>\r\n" + 
				"                <size>1</size>\r\n" + 
				"                <bitFilled>0</bitFilled>\r\n" + 
				"                <fieldLength>4</fieldLength>\r\n" + 
				"                <fieldStartByte>16</fieldStartByte>\r\n" + 
				"                <defaultValue>1000</defaultValue>\r\n" + 
				"                <judge>0</judge>\r\n" + 
				"                <FieldSituationType>0</FieldSituationType>\r\n" + 
				"                <info></info>\r\n" + 
				"            </field>\r\n" + 
				"            <field key=\"time\">\r\n" + 
				"                <orderNo>7</orderNo>\r\n" + 
				"                <key>time</key>\r\n" + 
				"                <fieldDescripId> -time</fieldDescripId>\r\n" + 
				"                <note>时间</note>\r\n" + 
				"                <fieldType>int</fieldType>\r\n" + 
				"                <size>1</size>\r\n" + 
				"                <bitFilled>0</bitFilled>\r\n" + 
				"                <fieldLength>4</fieldLength>\r\n" + 
				"                <fieldStartByte>20</fieldStartByte>\r\n" + 
				"                <defaultValue>0</defaultValue>\r\n" + 
				"                <judge>0</judge>\r\n" + 
				"                <FieldSituationType>0</FieldSituationType>\r\n" + 
				"                <info></info>\r\n" + 
				"            </field>\r\n" + 
				"            <field key=\"range\">\r\n" + 
				"                <orderNo>8</orderNo>\r\n" + 
				"                <key>range</key>\r\n" + 
				"                <fieldDescripId> -range</fieldDescripId>\r\n" + 
				"                <note>点迹幅度</note>\r\n" + 
				"                <fieldType>short</fieldType>\r\n" + 
				"                <size>1</size>\r\n" + 
				"                <bitFilled>0</bitFilled>\r\n" + 
				"                <fieldLength>2</fieldLength>\r\n" + 
				"                <fieldStartByte>24</fieldStartByte>\r\n" + 
				"                <defaultValue>0</defaultValue>\r\n" + 
				"                <judge>0</judge>\r\n" + 
				"                <FieldSituationType>0</FieldSituationType>\r\n" + 
				"                <info></info>\r\n" + 
				"            </field>\r\n" + 
				"            <field key=\"db\">\r\n" + 
				"                <orderNo>9</orderNo>\r\n" + 
				"                <key>db</key>\r\n" + 
				"                <fieldDescripId> -db</fieldDescripId>\r\n" + 
				"                <note>点迹信噪比</note>\r\n" + 
				"                <fieldType>short</fieldType>\r\n" + 
				"                <size>1</size>\r\n" + 
				"                <bitFilled>0</bitFilled>\r\n" + 
				"                <fieldLength>2</fieldLength>\r\n" + 
				"                <fieldStartByte>26</fieldStartByte>\r\n" + 
				"                <defaultValue>0</defaultValue>\r\n" + 
				"                <judge>0</judge>\r\n" + 
				"                <FieldSituationType>0</FieldSituationType>\r\n" + 
				"                <info></info>\r\n" + 
				"            </field>\r\n" + 
				"            <field key=\"ddone\">\r\n" + 
				"                <orderNo>10</orderNo>\r\n" + 
				"                <key>ddone</key>\r\n" + 
				"                <fieldDescripId> -ddone</fieldDescripId>\r\n" + 
				"                <note>待定1</note>\r\n" + 
				"                <fieldType>short</fieldType>\r\n" + 
				"                <size>1</size>\r\n" + 
				"                <bitFilled>0</bitFilled>\r\n" + 
				"                <fieldLength>2</fieldLength>\r\n" + 
				"                <fieldStartByte>28</fieldStartByte>\r\n" + 
				"                <defaultValue>0</defaultValue>\r\n" + 
				"                <judge>0</judge>\r\n" + 
				"                <FieldSituationType>0</FieldSituationType>\r\n" + 
				"                <info></info>\r\n" + 
				"            </field>\r\n" + 
				"            <field key=\"ddtwo\">\r\n" + 
				"                <orderNo>11</orderNo>\r\n" + 
				"                <key>ddtwo</key>\r\n" + 
				"                <fieldDescripId> -ddtwo</fieldDescripId>\r\n" + 
				"                <note>待定2</note>\r\n" + 
				"                <fieldType>short</fieldType>\r\n" + 
				"                <size>1</size>\r\n" + 
				"                <bitFilled>0</bitFilled>\r\n" + 
				"                <fieldLength>2</fieldLength>\r\n" + 
				"                <fieldStartByte>30</fieldStartByte>\r\n" + 
				"                <defaultValue>0</defaultValue>\r\n" + 
				"                <judge>0</judge>\r\n" + 
				"                <FieldSituationType>0</FieldSituationType>\r\n" + 
				"                <info></info>\r\n" + 
				"            </field>\r\n" + 
				"            <field key=\"ddthree\">\r\n" + 
				"                <orderNo>12</orderNo>\r\n" + 
				"                <key>ddthree</key>\r\n" + 
				"                <fieldDescripId> -ddthree</fieldDescripId>\r\n" + 
				"                <note>待定3</note>\r\n" + 
				"                <fieldType>short</fieldType>\r\n" + 
				"                <size>1</size>\r\n" + 
				"                <bitFilled>0</bitFilled>\r\n" + 
				"                <fieldLength>2</fieldLength>\r\n" + 
				"                <fieldStartByte>32</fieldStartByte>\r\n" + 
				"                <defaultValue>0</defaultValue>\r\n" + 
				"                <judge>0</judge>\r\n" + 
				"                <FieldSituationType>0</FieldSituationType>\r\n" + 
				"                <info></info>\r\n" + 
				"            </field>\r\n" + 
				"            <field key=\"ddfour\">\r\n" + 
				"                <orderNo>13</orderNo>\r\n" + 
				"                <key>ddfour</key>\r\n" + 
				"                <fieldDescripId> -ddfour</fieldDescripId>\r\n" + 
				"                <note>待定4</note>\r\n" + 
				"                <fieldType>short</fieldType>\r\n" + 
				"                <size>1</size>\r\n" + 
				"                <bitFilled>0</bitFilled>\r\n" + 
				"                <fieldLength>2</fieldLength>\r\n" + 
				"                <fieldStartByte>34</fieldStartByte>\r\n" + 
				"                <defaultValue>0</defaultValue>\r\n" + 
				"                <judge>0</judge>\r\n" + 
				"                <FieldSituationType>0</FieldSituationType>\r\n" + 
				"                <info></info>\r\n" + 
				"            </field>\r\n" + 
				"            <field key=\"hlct\">\r\n" + 
				"                <orderNo>14</orderNo>\r\n" + 
				"                <key>hlct</key>\r\n" + 
				"                <fieldDescripId> -hlct</fieldDescripId>\r\n" + 
				"                <note>雷控时间高位</note>\r\n" + 
				"                <fieldType>short</fieldType>\r\n" + 
				"                <size>1</size>\r\n" + 
				"                <bitFilled>0</bitFilled>\r\n" + 
				"                <fieldLength>2</fieldLength>\r\n" + 
				"                <fieldStartByte>36</fieldStartByte>\r\n" + 
				"                <defaultValue>0</defaultValue>\r\n" + 
				"                <judge>0</judge>\r\n" + 
				"                <FieldSituationType>0</FieldSituationType>\r\n" + 
				"                <info></info>\r\n" + 
				"            </field>\r\n" + 
				"            <field key=\"tp\">\r\n" + 
				"                <orderNo>15</orderNo>\r\n" + 
				"                <key>tp</key>\r\n" + 
				"                <fieldDescripId> -tp</fieldDescripId>\r\n" + 
				"                <note>点迹过滤状态</note>\r\n" + 
				"                <fieldType>short</fieldType>\r\n" + 
				"                <size>1</size>\r\n" + 
				"                <bitFilled>0</bitFilled>\r\n" + 
				"                <fieldLength>2</fieldLength>\r\n" + 
				"                <fieldStartByte>38</fieldStartByte>\r\n" + 
				"                <defaultValue>0</defaultValue>\r\n" + 
				"                <judge>0</judge>\r\n" + 
				"                <FieldSituationType>0</FieldSituationType>\r\n" + 
				"                <info></info>\r\n" + 
				"            </field>\r\n" + 
				"            <field key=\"ddfive\">\r\n" + 
				"                <orderNo>16</orderNo>\r\n" + 
				"                <key>ddfive</key>\r\n" + 
				"                <fieldDescripId> -ddfive</fieldDescripId>\r\n" + 
				"                <note>待定5</note>\r\n" + 
				"                <fieldType>short</fieldType>\r\n" + 
				"                <size>1</size>\r\n" + 
				"                <bitFilled>0</bitFilled>\r\n" + 
				"                <fieldLength>2</fieldLength>\r\n" + 
				"                <fieldStartByte>40</fieldStartByte>\r\n" + 
				"                <defaultValue>0</defaultValue>\r\n" + 
				"                <judge>0</judge>\r\n" + 
				"                <FieldSituationType>0</FieldSituationType>\r\n" + 
				"                <info></info>\r\n" + 
				"            </field>\r\n" + 
				"            <field key=\"ddsix\">\r\n" + 
				"                <orderNo>17</orderNo>\r\n" + 
				"                <key>ddsix</key>\r\n" + 
				"                <fieldDescripId> -ddsix</fieldDescripId>\r\n" + 
				"                <note>待定6</note>\r\n" + 
				"                <fieldType>short</fieldType>\r\n" + 
				"                <size>1</size>\r\n" + 
				"                <bitFilled>0</bitFilled>\r\n" + 
				"                <fieldLength>2</fieldLength>\r\n" + 
				"                <fieldStartByte>42</fieldStartByte>\r\n" + 
				"                <defaultValue>0</defaultValue>\r\n" + 
				"                <judge>0</judge>\r\n" + 
				"                <FieldSituationType>0</FieldSituationType>\r\n" + 
				"                <info></info>\r\n" + 
				"            </field>\r\n" + 
				"            <field key=\"ddseven\">\r\n" + 
				"                <orderNo>18</orderNo>\r\n" + 
				"                <key>ddseven</key>\r\n" + 
				"                <fieldDescripId> -ddseven</fieldDescripId>\r\n" + 
				"                <note>待定7</note>\r\n" + 
				"                <fieldType>short</fieldType>\r\n" + 
				"                <size>1</size>\r\n" + 
				"                <bitFilled>0</bitFilled>\r\n" + 
				"                <fieldLength>2</fieldLength>\r\n" + 
				"                <fieldStartByte>44</fieldStartByte>\r\n" + 
				"                <defaultValue>0</defaultValue>\r\n" + 
				"                <judge>0</judge>\r\n" + 
				"                <FieldSituationType>0</FieldSituationType>\r\n" + 
				"                <info></info>\r\n" + 
				"            </field>\r\n" + 
				"            <field key=\"ddeight\">\r\n" + 
				"                <orderNo>19</orderNo>\r\n" + 
				"                <key>ddeight</key>\r\n" + 
				"                <fieldDescripId> -ddeight</fieldDescripId>\r\n" + 
				"                <note>待定8</note>\r\n" + 
				"                <fieldType>short</fieldType>\r\n" + 
				"                <size>1</size>\r\n" + 
				"                <bitFilled>0</bitFilled>\r\n" + 
				"                <fieldLength>2</fieldLength>\r\n" + 
				"                <fieldStartByte>46</fieldStartByte>\r\n" + 
				"                <defaultValue>0</defaultValue>\r\n" + 
				"                <judge>0</judge>\r\n" + 
				"                <FieldSituationType>0</FieldSituationType>\r\n" + 
				"                <info></info>\r\n" + 
				"            </field>\r\n" + 
				"        </fields>\r\n" + 
				"    </set>\r\n" + 
				"    <set id=\"x268528ffff284765b9b52ee374a27fa8\">\r\n" + 
				"        <baseInfo>\r\n" + 
				"            <name>tail</name>\r\n" + 
				"            <note> </note>\r\n" + 
				"            <type> </type>\r\n" + 
				"            <maxOrderNo>1</maxOrderNo>\r\n" + 
				"            <length>2</length>\r\n" + 
				"            <constraint> </constraint>\r\n" + 
				"            <repeat>1</repeat>\r\n" + 
				"        </baseInfo>\r\n" + 
				"        <fields>\r\n" + 
				"            <field key=\"end\">\r\n" + 
				"                <orderNo>0</orderNo>\r\n" + 
				"                <key>end</key>\r\n" + 
				"                <fieldDescripId> </fieldDescripId>\r\n" + 
				"                <note>结束</note>\r\n" + 
				"                <fieldType>short</fieldType>\r\n" + 
				"                <size>1</size>\r\n" + 
				"                <bitFilled>0</bitFilled>\r\n" + 
				"                <fieldLength>2</fieldLength>\r\n" + 
				"                <fieldStartByte>48</fieldStartByte>\r\n" + 
				"                <defaultValue>0</defaultValue>\r\n" + 
				"                <judge>0</judge>\r\n" + 
				"                <FieldSituationType>0</FieldSituationType>\r\n" + 
				"                <info></info>\r\n" + 
				"            </field>\r\n" + 
				"        </fields>\r\n" + 
				"    </set>\r\n" + 
				"    <fieldDesciptionDict/>\r\n" + 
				"    <formulas/>\r\n" + 
				"</Protocol>\r\n" + 
				"\r\n" + 
				"";
		protoMap.put("xmlProto", "");
		TestXml2 t = new TestXml2();
		String protomsg = "b1b10000000000000bb8000003e80bb8000003e8000000000000000000000000000000000000000000000000000000000000";
		String path = "C:\\Users\\ZHANGJX\\Desktop\\radar\\dianji.xml";
		String p = t.getProto(path, "xmlProto", protoMap, protomsg);
		System.out.println(p);

	}

	/**
	 * 解析报文
	 * 
	 * @param path     xml文件路径
	 * @param protomsg 报文
	 * @throws Exception
	 */
	public String getProto(String path, String mapKey, Map<String, String> protoMap, String protomsg) {
		Map<String, String> resMap = new HashMap<String, String>();
		List<Map<Object, Object>> proto = new ArrayList<Map<Object, Object>>();
		if (protoMap != null) {
			if (protoMap.size() > 0 && protoMap.get(mapKey) != null && !protoMap.get(mapKey).equals("")) {
				System.out.println("使用  Map  规则");
				proto = getProtoRule(protoMap.get(mapKey));
			} else {
				System.out.println("使用  文件  规则");
				String fileProto = getFileProto(path, "UTF-8");
				proto = getProtoRule(fileProto);
				protoMap.put(mapKey, fileProto);
			}
			if (!proto.isEmpty()) {
				for (Map<Object, Object> map : proto) {
					// boolean postive = !((String) map.get("fieldDescripId")).trim().contains("-");
					String key = (String) map.get("key");
					String value = "";
					String type = (String) map.get("fieldType");
					int length = Integer.parseInt((String) map.get("fieldLength"));
					int startbyte = Integer.parseInt((String) map.get("fieldStartByte"));
					String m = protomsg.substring(startbyte * 2, (startbyte + length) * 2);
					// System.out.println(m);

					if (type.contains("int")) {
						BigInteger bi = new BigInteger(m, 16);
						int intVal = bi.intValue();
						value = String.valueOf(intVal);
						// System.out.println(bi.intValue());
					} else if (type.equals("short")) {
						// System.out.println(byte2short(toByteArray(m)));
						short shortVal = byte2short(toByteArray(m));
						value = String.valueOf(shortVal);
					} else if (type.equals("char")) {
						// System.out.println(toByteArray(m)[0]);
						value = String.valueOf(toByteArray(m)[0]);
					} else if (type.equals("long")) {
						// 4个字节最多为2^32 -1 ，int的最大值
						BigInteger bi = new BigInteger(m, 16);
						long longVal = bi.intValue();
						value = String.valueOf(longVal);
						// System.out.println(bi.intValue());
					}
					resMap.put(key, value);
				}
			}
		}

		return JSONObject.toJSONString(resMap);
	}

	private static short byte2short(byte[] b) {
		short l = 0;
		for (int i = 0; i < 2; i++) {
			l <<= 8; // <<=和我们的 +=是一样的，意思就是 l = l << 8
			l |= (b[i] & 0xff); // 和上面也是一样的 l = l | (b[i]&0xff)
		}
		return l;
	}

	private static byte[] toByteArray(String hexString) {
		hexString = hexString.toLowerCase();
		final byte[] byteArray = new byte[hexString.length() / 2];
		int k = 0;
		for (int i = 0; i < byteArray.length; i++) {// 因为是16进制，最多只会占用4位，转换成字节需要两个16进制的字符，高位在先
			byte high = (byte) (Character.digit(hexString.charAt(k), 16) & 0xff);
			byte low = (byte) (Character.digit(hexString.charAt(k + 1), 16) & 0xff);
			byteArray[i] = (byte) (high << 4 | low);
			k += 2;
		}
		return byteArray;
	}

	/**
	 * 解析字符串规则
	 * 
	 * @param xmlProto
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private List<Map<Object, Object>> getProtoRule(String xmlProto) {
		List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
		
		try {
			SAXBuilder saxBuilder = new SAXBuilder();
			Document document = saxBuilder.build(new StringReader(xmlProto));			
			// 获取根节点
			Element rootElement = document.getRootElement();
			// 获取子节点
			List<Element> children = rootElement.getChildren();
			for (Element child : children) {
				List<Element> childrenList = child.getChildren();
				if ("set".equals(child.getName())) {// 只取set里的内容
//					isBody = true;
					for (Element fields : childrenList) {
//						if ("baseInfo".equals(fields.getName())) {
//							List<Element> baseInfoList = fields.getChildren();
//							for (Element e : baseInfoList) {
//								if ("name".equals(e.getName())) {
//									if ("head".equals(e.getText()) || "tail".equals(e.getText())) {// head和end内容不取，只取body
//										isBody = false;
//										break;
//									} else if ("body".equals(e.getText())) {
//										isBody = true;
//									}
//								}
//							}
//						}
//						if (!isBody)
//							break;
						if ("fields".equals(fields.getName())) {
							List<Element> fieldList = fields.getChildren();
							for (Element e : fieldList) {// 第三层取值
								Map<Object, Object> map = new LinkedHashMap<Object, Object>();
								for (Object element : e.getContent()) {// 最后取值
									if (element instanceof Element) {
										map.put(((Element) element).getName(), ((Element) element).getText());
									}
								}
								list.add(map);
							}
						}
					}
				}
			}
		} catch (JDOMException | IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 从文件获取报文解析规则
	 * @param path xml文件路径
	 * @param encode xml文件编码
	 * @return
	 */
	private String getFileProto(String path, String encode) {
		String resStr = "";
		InputStream isFile = null;
		ByteArrayOutputStream bo = null;
		try {
			// 1.创建SAXBuilder对象
			SAXBuilder saxBuilder = new SAXBuilder();
			// 2.创建输入流
			isFile = new FileInputStream(new File(path));
			// 3.将输入流加载到build中
			Document document = saxBuilder.build(isFile);
			Format format = Format.getCompactFormat();
			format.setEncoding(encode);// 设置xml文件的字符为UTF-8，解决中文问题
			XMLOutputter xmlout = new XMLOutputter();
			bo = new ByteArrayOutputStream();
			xmlout.output(document, bo);
			resStr = bo.toString().trim();
		} catch (JDOMException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (isFile != null) {
					isFile.close();
				}
				if (bo != null) {
					bo.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resStr;
	}
}
