function loadTxt()
    {
    var txtLang = document.getElementsByName("txtLang");
    txtLang[0].innerHTML = "ͼƬ·��";
    txtLang[1].innerHTML = "����";
    txtLang[2].innerHTML = "���";
    txtLang[3].innerHTML = "λ��";
    txtLang[4].innerHTML = "��";
    txtLang[5].innerHTML = "�߿�";
    txtLang[6].innerHTML = "��";
    txtLang[7].innerHTML = "���";
    txtLang[8].innerHTML = "��";
    txtLang[9].innerHTML = "�߶�";
    txtLang[10].innerHTML = "��";
    
    var optLang = document.getElementsByName("optLang");
    optLang[0].text = "absBottom";
    optLang[1].text = "absMiddle";
    optLang[2].text = "baseline";
    optLang[3].text = "bottom";
    optLang[4].text = "left";
    optLang[5].text = "middle";
    optLang[6].text = "right";
    optLang[7].text = "textTop";
    optLang[8].text = "top";
 
    document.getElementById("btnBorder").value = " ѡ����ʽ ";
    document.getElementById("btnReset").value = "��ԭ"
    
    document.getElementById("btnCancel").value = "ȡ��";
    document.getElementById("btnInsert").value = "����";
    document.getElementById("btnApply").value = "Ӧ��";
    document.getElementById("btnOk").value = "ȷ��";
    }
function writeTitle()
    {
    document.write("<title>Image</title>")
    }