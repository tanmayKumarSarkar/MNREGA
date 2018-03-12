var gram_panchayat={};
gram_panchayat['Ahamadpur GP']=['Select Village','Sundarpur','Kusum Jatra','Palash Danga'];
gram_panchayat['Amarpur GP']=['Select Village','Amarpur','Gargaria','Ikra'];
gram_panchayat['Panrui GP']=['Select Village','Panrui','Vola Goria','Neturi'];
gram_panchayat['Khatra GP']=['Select Village','Gadarhar','Papda','jitpur'];
gram_panchayat['Kalyani GP']=['Select Village','Harifela','Daldali','Lauda'];
gram_panchayat['Indpur GP']=['Select Village','Bangla','Indpur','Sunuk Pahari'];
gram_panchayat['Anda GP']=['Select Village',' Mahira',' Kajora',' Harishpur'];
gram_panchayat['mnb']=['Select Village','','',''];
gram_panchayat['b']=['Select Village','','',''];
gram_panchayat['dfc']=['Select Village','','','']; 
/*<---------------------------------------------------------------------------------------------------------------------------------------------------->*/
var District={};
District['Bankura']=['Kalyani GP','Indpur GP','Khatra GP'];
District['Bardhaman']=['SUSUNIA GP','KUSUMGRAM GP','Andal GP'];
District['Birbhum']=['Ahamadpur GP','Amarpur GP','Panrui GP'];
District['Cooch Behar']=['Gopalpur GP','Khagrabari GP','Khapaidanga GP'];
District['Dakshin Dinajpur']=['Akcha GP','Beroil GP','Karanji GP'];
District['East Midnapore']=['Haldia GP','Padima GP','Simulia GP'];
District['Hooghly']=['Batanal GP','Arandi-I GP','Malaypur-I GP'];
District['Howrah']=['Chandrapur GP','Khardaha GP','Kanpur GP'];
District['Jalpaiguri']=['Banchukamari GP','Mathura GP','Pararpar GP'];
District['Malda']=['Alihanda GP','Chanchal GP','Bhagawanpur GP'];
District['Murshidabad']=['Mirzapur-I GP','Kamnagar GP','Kashipur GP'];
District['Nadia']=['Bagberia GP','Brittihuda GP','Chapra-I GP'];
District['North 24 Parganas']=['Chandipur GP','Chatra GP','Boyra GP','Gazna GP'];
District['Purulia']=['Dardra GP','Bela GP','Jenulua GP'];
District['Siliguri']=['New Jalpaiguri GP','Jalandi GP','Siliguri GP'];
District['South 24 Parganas']=['Amjhara GP','Basanti GP','Joytishpur GP'];
District['Uttar Dinajpur']=['Mahura GP','Goti GP','Lodhan GP'];
District['West Midnapore']=['Jara GP','Laxmipur GP','Mangrul GP'];



/*<---------------------------------------------------------------------------------------------------------------------------------------------------->*/


/*<---------------------------------------------------------------------------------------------------------------------------------------------------->*/
function ChangeDistrictList()
{
var DistrictList=document.getElementById("District_list");
var GPList=document.getElementById("Gram_Panchayat_list");


var SetDistrict=DistrictList.options[DistrictList.selectedIndex].value;


while (GPList.options.length)
  {
  GPList.remove(0);
  }

  
var District_all=District[SetDistrict];


if (District_all)
  {
  for (var i=0;i<District_all.length;i++)
    {
    var District_list=new Option(District_all[i],i);
    GPList.options.add(District_list);
	GPList.options[i].value=District_all[i];
    }
  }
} 
/*<---------------------------------------------------------------------------------------------------------------------------------------------------->*/
function ChangeGP(){
	var GPList=document.getElementById("Gram_Panchayat_list");
	var villageList=document.getElementById("Village_list");
	
	var SetGP=GPList.options[GPList.selectedIndex].value;
	
while (villageList.options.length)
  {
  villageList.remove(0);
  }

var GP_all=gram_panchayat[SetGP];

if (GP_all)
  { 
  for (var i=0;i<GP_all.length;i++)
    {
    var Gram_Panchayat_list=new Option(GP_all[i],i);	
    villageList.options.add(Gram_Panchayat_list);
	villageList.options[i].value=GP_all[i];
	
    }
  }else alert("not working");
}
