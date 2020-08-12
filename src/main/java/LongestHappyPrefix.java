import java.util.HashSet;
import java.util.Set;

/**
 * @author schandna created on 02/04/20
 */
public class LongestHappyPrefix {

    public static void main(String[] args) {
        String sP = null;
        String s = "lbywxrxepmvsvlcaxgibdnffirmsxcpdlambtizoiflpzalqzzwapzfqxjsxazngtwkhoywuyduwlyhdmaqodmjympjrmakcwzghkzfeapsbwcgstmxfiusozuwcitzcsyvvuotyqewzwiifmxiffykgribzwupgiqqipefxgsoorekuieclzfgnymoanhmjajcfhcydrlvtvqxyfhgxgjlfgtmtaorwzktallnzdqnqavdwxfftrosmprugqougadicdwsvucbrbxspfmjunroegbydavcnsakajpiihijduexlnmsrvblzybxljuvzgssqheitqwxzfegesjrnloumysdprsdsgccexnvfxbxwxidrowykycgmvohokgpctznfsfcozujpivgvmuyvmyubfvxipldogacvlnhfceypgkqkedzyezpbmwjftstqtmqpkrvxdtonmcqepvqcjncuqfjpssjqfjjzusnapdlsvtcagkymnwigcdqaztrjabmlqfzsiwjcfxonascjfeljsjhdwtupkavlvhxdfboxroevfbosdgsdaqerghssxxidlwwiptkhuibkuwdkkslknmygkgkazwixvqiegmawralhfvdimhrtqltctetvzwgnnrzhhrgtbwnljtzqyccfmierpsgmduznlpmbqghmoqvvnhzcvybxemhiebebolkumnlfehwfoajqllsbmfunbfjesmigxwdvuxyvypuqetfmdpycyjycjkqnnzhyczcpdhcesvpebjvsjycruameowgkprdwrvphnxgedqcnsvpmdeigfovyrkntzzrtwbltduefcctvwuajomqqxlbywpozaolbbvldfhdrejiigofmxpqegphbuutnqbuguymrhhmrziwczxowwliimcrsjnyctnecxhumivfgnnysocapupgyfplhcmvjrlhgjuybuxkcwowqkiubthmgjhakzhqweqytuivqwgmnlbywxrxepmvsvlcaxgibdnffirmsxcpdlambtizoiflpzalqzzwapzfqxjsxazngtwkhoywuyduwlyhdmaqodmjympjrmakcwzghkzfeapsbwcgstmxfiusozuwcitzcsyvvuotyqewzwiifmxiffykgribzwupgiqqipefxgsoorekuieclzfgnymoanhmjajcfhcydrlvtvqxyfhgxgjlfgtmtaorwzktallnzdqnqavdwxfftrosmprugqougadicdwsvucbrbxspfmjunroegbydavcnsakajpiihijduexlnmsrvblzybxljuvzgssqheitqwxzfegesjrnloumysdprsdsgccexnvfxbxwxidrowykycgmvohokgpctznfsfcozujpivgvmuyvmyubfvxipldogacvlnhfceypgkqkedzyezpbmwjftstqtmqpkrvxdtonmcqepvqcjncuqfjpssjqfjjzusnapdlsvtcagkymnwigcdqaztrjabmlqfzsiwjcfxonascjfeljsjhdwtupkavlvhxdfboxroevfbosdgsdaqerghssxxidlwwiptkhuibkuwdkkslknmygkgkazwixvqiegmawralhfvdimhrtqltctetvzwgnnrzhhrgtbwnljtzqyccfmierpsgmduznlpmbqghmoqvvnhzcvybxemhiebebolkumnlfehwfoajqllsbmfunbfjesmigxwdvuxyvypuqetfmdpycyjycjkqnnzhyczcpdhcesvpebjvsjycruameowgkprdwrvphnxgedqcnsvpmdeigfovyrkntzzrtwbltduefcctvwuajomqqxlbywpozaolbbvldfhdrejiigofmxpqegphbuutnqbuguymrhhmrziwczxowwliimcrsjnyctnecxhumivfgnnysocapupgyfplhcmvjrlhgjuybuxkcwowqkiubthmgjhakzhqweqytuivqwgmnlbywxrxepmvsvlcaxgibdnffirmsxcpdlambtizoiflpzalqzzwapzfqxjsxazngtwkhoywuyduwlyhdmaqodmjympjrmakcwzghkzfeapsbwcgstmxfiusozuwcitzcsyvvuotyqewzwiifmxiffykgribzwupgiqqipefxgsoorekuieclzfgnymoanhmjajcfhcydrlvtvqxyfhgxgjlfgtmtaorwzktallnzdqnqavdwxfftrosmprugqougadicdwsvucbrbxspfmjunroegbydavcnsakajpiihijduexlnmsrvblzybxljuvzgssqheitqwxzfegesjrnloumysdprsdsgccexnvfxbxwxidrowykycgmvohokgpctznfsfcozujpivgvmuyvmyubfvxipldogacvlnhfceypgkqkedzyezpbmwjftstqtmqpkrvxdtonmcqepvqcjncuqfjpssjqfjjzusnapdlsvtcagkymnwigcdqaztrjabmlqfzsiwjcfxonascjfeljsjhdwtupkavlvhxdfboxroevfbosdgsdaqerghssxxidlwwiptkhuibkuwdkkslknmygkgkazwixvqiegmawralhfvdimhrtqltctetvzwgnnrzhhrgtbwnljtzqyccfmierpsgmduznlpmbqghmoqvvnhzcvybxemhiebebolkumnlfehwfoajqllsbmfunbfjesmigxwdvuxyvypuqetfmdpycyjycjkqnnzhyczcpdhcesvpebjvsjycruameowgkprdwrvphnxgedqcnsvpmdeigfovyrkntzzrtwbltduefcctvwuajomqqxlbywpozaolbbvldfhdrejiigofmxpqegphbuutnqbuguymrhhmrziwczxowwliimcrsjnyctnecxhumivfgnnysocapupgyfplhcmvjrlhgjuybuxkcwowqkiubthmgjhakzhqweqytuivqwgmnlbywxrxepmvsvlcaxgibdnffirmsxcpdlambtizoiflpzalqzzwapzfqxjsxazngtwkhoywuyduwlyhdmaqodmjympjrmakcwzghkzfeapsbwcgstmxfiusozuwcitzcsyvvuotyqewzwiifmxiffykgribzwupgiqqipefxgsoorekuieclzfgnymoanhmjajcfhcydrlvtvqxyfhgxgjlfgtmtaorwzktallnzdqnqavdwxfftrosmprugqougadicdwsvucbrbxspfmjunroegbydavcnsakajpiihijduexlnmsrvblzybxljuvzgssqheitqwxzfegesjrnloumysdprsdsgccexnvfxbxwxidrowykycgmvohokgpctznfsfcozujpivgvmuyvmyubfvxipldogacvlnhfceypgkqkedzyezpbmwjftstqtmqpkrvxdtonmcqepvqcjncuqfjpssjqfjjzusnapdlsvtcagkymnwigcdqaztrjabmlqfzsiwjcfxonascjfeljsjhdwtupkavlvhxdfboxroevfbosdgsdaqerghssxxidlwwiptkhuibkuwdkkslknmygkgkazwixvqiegmawralhfvdimhrtqltctetvzwgnnrzhhrgtbwnljtzqyccfmierpsgmduznlpmbqghmoqvvnhzcvybxemhiebebolkumnlfehwfoajqllsbmfunbfjesmigxwdvuxyvypuqetfmdpycyjycjkqnnzhyczcpdhcesvpebjvsjycruameowgkprdwrvphnxgedqcnsvpmdeigfovyrkntzzrtwbltduefcctvwuajomqqxlbywpozaolbbvldfhdrejiigofmxpqegphbuutnqbuguymrhhmrziwczxowwliimcrsjnyctnecxhumivfgnnysocapupgyfplhcmvjrlhgjuybuxkcwowqkiubthmgjhakzhqweqytuivqwgmnlbywxrxepmvsvlcaxgibdnffirmsxcpdlambtizoiflpzalqzzwapzfqxjsxazngtwkhoywuyduwlyhdmaqodmjympjrmakcwzghkzfeapsbwcgstmxfiusozuwcitzcsyvvuotyqewzwiifmxiffykgribzwupgiqqipefxgsoorekuieclzfgnymoanhmjajcfhcydrlvtvqxyfhgxgjlfgtmtaorwzktallnzdqnqavdwxfftrosmprugqougadicdwsvucbrbxspfmjunroegbydavcnsakajpiihijduexlnmsrvblzybxljuvzgssqheitqwxzfegesjrnloumysdprsdsgccexnvfxbxwxidrowykycgmvohokgpctznfsfcozujpivgvmuyvmyubfvxipldogacvlnhfceypgkqkedzyezpbmwjftstqtmqpkrvxdtonmcqepvqcjncuqfjpssjqfjjzusnapdlsvtcagkymnwigcdqaztrjabmlqfzsiwjcfxonascjfeljsjhdwtupkavlvhxdfboxroevfbosdgsdaqerghssxxidlwwiptkhuibkuwdkkslknmygkgkazwixvqiegmawralhfvdimhrtqltctetvzwgnnrzhhrgtbwnljtzqyccfmierpsgmduznlpmbqghmoqvvnhzcvybxemhiebebolkumnlfehwfoajqllsbmfunbfjesmigxwdvuxyvypuqetfmdpycyjycjkqnnzhyczcpdhcesvpebjvsjycruameowgkprdwrvphnxgedqcnsvpmdeigfovyrkntzzrtwbltduefcctvwuajomqqxlbywpozaolbbvldfhdrejiigofmxpqegphbuutnqbuguymrhhmrziwczxowwliimcrsjnyctnecxhumivfgnnysocapupgyfplhcmvjrlhgjuybuxkcwowqkiubthmgjhakzhqweqytuivqwgmnlbywxrxepmvsvlcaxgibdnffirmsxcpdlambtizoiflpzalqzzwapzfqxjsxazngtwkhoywuyduwlyhdmaqodmjympjrmakcwzghkzfeapsbwcgstmxfiusozuwcitzcsyvvuotyqewzwiifmxiffykgribzwupgiqqipefxgsoorekuieclzfgnymoanhmjajcfhcydrlvtvqxyfhgxgjlfgtmtaorwzktallnzdqnqavdwxfftrosmprugqougadicdwsvucbrbxspfmjunroegbydavcnsakajpiihijduexlnmsrvblzybxljuvzgssqheitqwxzfegesjrnloumysdprsdsgccexnvfxbxwxidrowykycgmvohokgpctznfsfcozujpivgvmuyvmyubfvxipldogacvlnhfceypgkqkedzyezpbmwjftstqtmqpkrvxdtonmcqepvqcjncuqfjpssjqfjjzusnapdlsvtcagkymnwigcdqaztrjabmlqfzsiwjcfxonascjfeljsjhdwtupkavlvhxdfboxroevfbosdgsdaqerghssxxidlwwiptkhuibkuwdkkslknmygkgkazwixvqiegmawralhfvdimhrtqltctetvzwgnnrzhhrgtbwnljtzqyccfmierpsgmduznlpmbqghmoqvvnhzcvybxemhiebebolkumnlfehwfoajqllsbmfunbfjesmigxwdvuxyvypuqetfmdpycyjycjkqnnzhyczcpdhcesvpebjvsjycruameowgkprdwrvphnxgedqcnsvpmdeigfovyrkntzzrtwbltduefcctvwuajomqqxlbywpozaolbbvldfhdrejiigofmxpqegphbuutnqbuguymrhhmrziwczxowwliimcrsjnyctnecxhumivfgnnysocapupgyfplhcmvjrlhgjuybuxkcwowqkiubthmgjhakzhqweqytuivqwgmnlbywxrxepmvsvlcaxgibdnffirmsxcpdlambtizoiflpzalqzzwapzfqxjsxazngtwkhoywuyduwlyhdmaqodmjympjrmakcwzghkzfeapsbwcgstmxfiusozuwcitzcsyvvuotyqewzwiifmxiffykgribzwupgiqqipefxgsoorekuieclzfgnymoanhmjajcfhcydrlvtvqxyfhgxgjlfgtmtaorwzktallnzdqnqavdwxfftrosmprugqougadicdwsvucbrbxspfmjunroegbydavcnsakajpiihijduexlnmsrvblzybxljuvzgssqheitqwxzfegesjrnloumysdprsdsgccexnvfxbxwxidrowykycgmvohokgpctznfsfcozujpivgvmuyvmyubfvxipldogacvlnhfceypgkqkedzyezpbmwjftstqtmqpkrvxdtonmcqepvqcjncuqfjpssjqfjjzusnapdlsvtcagkymnwigcdqaztrjabmlqfzsiwjcfxonascjfeljsjhdwtupkavlvhxdfboxroevfbosdgsdaqerghssxxidlwwiptkhuibkuwdkkslknmygkgkazwixvqiegmawralhfvdimhrtqltctetvzwgnnrzhhrgtbwnljtzqyccfmierpsgmduznlpmbqghmoqvvnhzcvybxemhiebebolkumnlfehwfoajqllsbmfunbfjesmigxwdvuxyvypuqetfmdpycyjycjkqnnzhyczcpdhcesvpebjvsjycruameowgkprdwrvphnxgedqcnsvpmdeigfovyrkntzzrtwbltduefcctvwuajomqqxlbywpozaolbbvldfhdrejiigofmxpqegphbuutnqbuguymrhhmrziwczxowwliimcrsjnyctnecxhumivfgnnysocapupgyfplhcmvjrlhgjuybuxkcwowqkiubthmgjhakzhqweqytuivqwgmnlbywxrxepmvsvlcaxgibdnffirmsxcpdlambtizoiflpzalqzzwapzfqxjsxazngtwkhoywuyduwlyhdmaqodmjympjrmakcwzghkzfeapsbwcgstmxfiusozuwcitzcsyvvuotyqewzwiifmxiffykgribzwupgiqqipefxgsoorekuieclzfgnymoanhmjajcfhcydrlvtvqxyfhgxgjlfgtmtaorwzktallnzdqnqavdwxfftrosmprugqougadicdwsvucbrbxspfmjunroegbydavcnsakajpiihijduexlnmsrvblzybxljuvzgssqheitqwxzfegesjrnloumysdprsdsgccexnvfxbxwxidrowykycgmvohokgpctznfsfcozujpivgvmuyvmyubfvxipldogacvlnhfceypgkqkedzyezpbmwjftstqtmqpkrvxdtonmcqepvqcjncuqfjpssjqfjjzusnapdlsvtcagkymnwigcdqaztrjabmlqfzsiwjcfxonascjfeljsjhdwtupkavlvhxdfboxroevfbosdgsdaqerghssxxidlwwiptkhuibkuwdkkslknmygkgkazwixvqiegmawralhfvdimhrtqltctetvzwgnnrzhhrgtbwnljtzqyccfmierpsgmduznlpmbqghmoqvvnhzcvybxemhiebebolkumnlfehwfoajqllsbmfunbfjesmigxwdvuxyvypuqetfmdpycyjycjkqnnzhyczcpdhcesvpebjvsjycruameowgkprdwrvphnxgedqcnsvpmdeigfovyrkntzzrtwbltduefcctvwuajomqqxlbywpozaolbbvldfhdrejiigofmxpqegphbuutnqbuguymrhhmrziwczxowwliimcrsjnyctnecxhumivfgnnysocapupgyfplhcmvjrlhgjuybuxkcwowqkiubthmgjhakzhqweqytuivqwgmnlbywxrxepmvsvlcaxgibdnffirmsxcpdlambtizoiflpzalqzzwapzfqxjsxazngtwkhoywuyduwlyhdmaqodmjympjrmakcwzghkzfeapsbwcgstmxfiusozuwcitzcsyvvuotyqewzwiifmxiffykgribzwupgiqqipefxgsoorekuieclzfgnymoanhmjajcfhcydrlvtvqxyfhgxgjlfgtmtaorwzktallnzdqnqavdwxfftrosmprugqougadicdwsvucbrbxspfmjunroegbydavcnsakajpiihijduexlnmsrvblzybxljuvzgssqheitqwxzfegesjrnloumysdprsdsgccexnvfxbxwxidrowykycgmvohokgpctznfsfcozujpivgvmuyvmyubfvxipldogacvlnhfceypgkqkedzyezpbmwjftstqtmqpkrvxdtonmcqepvqcjncuqfjpssjqfjjzusnapdlsvtcagkymnwigcdqaztrjabmlqfzsiwjcfxonascjfeljsjhdwtupkavlvhxdfboxroevfbosdgsdaqerghssxxidlwwiptkhuibkuwdkkslknmygkgkazwixvqiegmawralhfvdimhrtqltctetvzwgnnrzhhrgtbwnljtzqyccfmierpsgmduznlpmbqghmoqvvnhzcvybxemhiebebolkumnlfehwfoajqllsbmfunbfjesmigxwdvuxyvypuqetfmdpycyjycjkqnnzhyczcpdhcesvpebjvsjycruameowgkprdwrvphnxgedqcnsvpmdeigfovyrkntzzrtwbltduefcctvwuajomqqxlbywpozaolbbvldfhdrejiigofmxpqegphbuutnqbuguymrhhmrziwczxowwliimcrsjnyctnecxhumivfgnnysocapupgyfplhcmvjrlhgjuybuxkcwowqkiubthmgjhakzhqweqytuivqwgmnlbywxrxepmvsvlcaxgibdnffirmsxcpdlambtizoiflpzalqzzwapzfqxjsxazngtwkhoywuyduwlyhdmaqodmjympjrmakcwzghkzfeapsbwcgstmxfiusozuwcitzcsyvvuotyqewzwiifmxiffykgribzwupgiqqipefxgsoorekuieclzfgnymoanhmjajcfhcydrlvtvqxyfhgxgjlfgtmtaorwzktallnzdqnqavdwxfftrosmprugqougadicdwsvucbrbxspfmjunroegbydavcnsakajpiihijduexlnmsrvblzybxljuvzgssqheitqwxzfegesjrnloumysdprsdsgccexnvfxbxwxidrowykycgmvohokgpctznfsfcozujpivgvmuyvmyubfvxipldogacvlnhfceypgkqkedzyezpbmwjftstqtmqpkrvxdtonmcqepvqcjncuqfjpssjqfjjzusnapdlsvtcagkymnwigcdqaztrjabmlqfzsiwjcfxonascjfeljsjhdwtupkavlvhxdfboxroevfbosdgsdaqerghssxxidlwwiptkhuibkuwdkkslknmygkgkazwixvqiegmawralhfvdimhrtqltctetvzwgnnrzhhrgtbwnljtzqyccfmierpsgmduznlpmbqghmoqvvnhzcvybxemhiebebolkumnlfehwfoajqllsbmfunbfjesmigxwdvuxyvypuqetfmdpycyjycjkqnnzhyczcpdhcesvpebjvsjycruameowgkprdwrvphnxgedqcnsvpmdeigfovyrkntzzrtwbltduefcctvwuajomqqxlbywpozaolbbvldfhdrejiigofmxpqegphbuutnqbuguymrhhmrziwczxowwliimcrsjnyctnecxhumivfgnnysocapupgyfplhcmvjrlhgjuybuxkcwowqkiubthmgjhakzhqweqytuivqwgmnlbywxrxepmvsvlcaxgibdnffirmsxcpdlambtizoiflpzalqzzwapzfqxjsxazngtwkhoywuyduwlyhdmaqodmjympjrmakcwzghkzfeapsbwcgstmxfiusozuwcitzcsyvvuotyqewzwiifmxiffykgribzwupgiqqipefxgsoorekuieclzfgnymoanhmjajcfhcydrlvtvqxyfhgxgjlfgtmtaorwzktallnzdqnqavdwxfftrosmprugqougadicdwsvucbrbxspfmjunroegbydavcnsakajpiihijduexlnmsrvblzybxljuvzgssqheitqwxzfegesjrnloumysdprsdsgccexnvfxbxwxidrowykycgmvohokgpctznfsfcozujpivgvmuyvmyubfvxipldogacvlnhfceypgkqkedzyezpbmwjftstqtmqpkrvxdtonmcqepvqcjncuqfjpssjqfjjzusnapdlsvtcagkymnwigcdqaztrjabmlqfzsiwjcfxonascjfeljsjhdwtupkavlvhxdfboxroevfbosdgsdaqerghssxxidlwwiptkhuibkuwdkkslknmygkgkazwixvqiegmawralhfvdimhrtqltctetvzwgnnrzhhrgtbwnljtzqyccfmierpsgmduznlpmbqghmoqvvnhzcvybxemhiebebolkumnlfehwfoajqllsbmfunbfjesmigxwdvuxyvypuqetfmdpycyjycjkqnnzhyczcpdhcesvpebjvsjycruameowgkprdwrvphnxgedqcnsvpmdeigfovyrkntzzrtwbltduefcctvwuajomqqxlbywpozaolbbvldfhdrejiigofmxpqegphbuutnqbuguymrhhmrziwczxowwliimcrsjnyctnecxhumivfgnnysocapupgyfplhcmvjrlhgjuybuxkcwowqkiubthmgjhakzhqweqytuivqwgmnlbywxrxepmvsvlcaxgibdnffirmsxcpdlambtizoiflpzalqzzwapzfqxjsxazngtwkhoywuyduwlyhdmaqodmjympjrmakcwzghkzfeapsbwcgstmxfiusozuwcitzcsyvvuotyqewzwiifmxiffykgribzwupgiqqipefxgsoorekuieclzfgnymoanhmjajcfhcydrlvtvqxyfhgxgjlfgtmtaorwzktallnzdqnqavdwxfftrosmprugqougadicdwsvucbrbxspfmjunroegbydavcnsakajpiihijduexlnmsrvblzybxljuvzgssqheitqwxzfegesjrnloumysdprsdsgccexnvfxbxwxidrowykycgmvohokgpctznfsfcozujpivgvmuyvmyubfvxipldogacvlnhfceypgkqkedzyezpbmwjftstqtmqpkrvxdtonmcqepvqcjncuqfjpssjqfjjzusnapdlsvtcagkymnwigcdqaztrjabmlqfzsiwjcfxonascjfeljsjhdwtupkavlvhxdfboxroevfbosdgsdaqerghssxxidlwwiptkhuibkuwdkkslknmygkgkazwixvqiegmawralhfvdimhrtqltctetvzwgnnrzhhrgtbwnljtzqyccfmierpsgmduznlpmbqghmoqvvnhzcvybxemhiebebolkumnlfehwfoajqllsbmfunbfjesmigxwdvuxyvypuqetfmdpycyjycjkqnnzhyczcpdhcesvpebjvsjycruameowgkprdwrvphnxgedqcnsvpmdeigfovyrkntzzrtwbltduefcctvwuajomqqxlbywpozaolbbvldfhdrejiigofmxpqegphbuutnqbuguymrhhmrziwczxowwliimcrsjnyctnecxhumivfgnnysocapupgyfplhcmvjrlhgjuybuxkcwowqkiubthmgjhakzhqweqytuivqwgmnlbywxrxepmvsvlcaxgibdnffirmsxcpdlambtizoiflpzalqzzwapzfqxjsxazngtwkhoywuyduwlyhdmaqodmjympjrmakcwzghkzfeapsbwcgstmxfiusozuwcitzcsyvvuotyqewzwiifmxiffykgribzwupgiqqipefxgsoorekuieclzfgnymoanhmjajcfhcydrlvtvqxyfhgxgjlfgtmtaorwzktallnzdqnqavdwxfftrosmprugqougadicdwsvucbrbxspfmjunroegbydavcnsakajpiihijduexlnmsrvblzybxljuvzgssqheitqwxzfegesjrnloumysdprsdsgccexnvfxbxwxidrowykycgmvohokgpctznfsfcozujpivgvmuyvmyubfvxipldogacvlnhfceypgkqkedzyezpbmwjftstqtmqpkrvxdtonmcqepvqcjncuqfjpssjqfjjzusnapdlsvtcagkymnwigcdqaztrjabmlqfzsiwjcfxonascjfeljsjhdwtupkavlvhxdfboxroevfbosdgsdaqerghssxxidlwwiptkhuibkuwdkkslknmygkgkazwixvqiegmawralhfvdimhrtqltctetvzwgnnrzhhrgtbwnljtzqyccfmierpsgmduznlpmbqghmoqvvnhzcvybxemhiebebolkumnlfehwfoajqllsbmfunbfjesmigxwdvuxyvypuqetfmdpycyjycjkqnnzhyczcpdhcesvpebjvsjycruameowgkprdwrvphnxgedqcnsvpmdeigfovyrkntzzrtwbltduefcctvwuajomqqxlbywpozaolbbvldfhdrejiigofmxpqegphbuutnqbuguymrhhmrziwczxowwliimcrsjnyctnecxhumivfgnnysocapupgyfplhcmvjrlhgjuybuxkcwowqkiubthmgjhakzhqweqytuivqwgmnlbywxrxepmvsvlcaxgibdnffirmsxcpdlambtizoiflpzalqzzwapzfqxjsxazngtwkhoywuyduwlyhdmaqodmjympjrmakcwzghkzfeapsbwcgstmxfiusozuwcitzcsyvvuotyqewzwiifmxiffykgribzwupgiqqipefxgsoorekuieclzfgnymoanhmjajcfhcydrlvtvqxyfhgxgjlfgtmtaorwzktallnzdqnqavdwxfftrosmprugqougadicdwsvucbrbxspfmjunroegbydavcnsakajpiihijduexlnmsrvblzybxljuvzgssqheitqwxzfegesjrnloumysdprsdsgccexnvfxbxwxidrowykycgmvohokgpctznfsfcozujpivgvmuyvmyubfvxipldogacvlnhfceypgkqkedzyezpbmwjftstqtmqpkrvxdtonmcqepvqcjncuqfjpssjqfjjzusnapdlsvtcagkymnwigcdqaztrjabmlqfzsiwjcfxonascjfeljsjhdwtupkavlvhxdfboxroevfbosdgsdaqerghssxxidlwwiptkhuibkuwdkkslknmygkgkazwixvqiegmawralhfvdimhrtqltctetvzwgnnrzhhrgtbwnljtzqyccfmierpsgmduznlpmbqghmoqvvnhzcvybxemhiebebolkumnlfehwfoajqllsbmfunbfjesmigxwdvuxyvypuqetfmdpycyjycjkqnnzhyczcpdhcesvpebjvsjycruameowgkprdwrvphnxgedqcnsvpmdeigfovyrkntzzrtwbltduefcctvwuajomqqxlbywpozaolbbvldfhdrejiigofmxpqegphbuutnqbuguymrhhmrziwczxowwliimcrsjnyctnecxhumivfgnnysocapupgyfplhcmvjrlhgjuybuxkcwowqkiubthmgjhakzhqweqytuivqwgmnlbywxrxepmvsvlcaxgibdnffirmsxcpdlambtizoiflpzalqzzwapzfqxjsxazngtwkhoywuyduwlyhdmaqodmjympjrmakcwzghkzfeapsbwcgstmxfiusozuwcitzcsyvvuotyqewzwiifmxiffykgribzwupgiqqipefxgsoorekuieclzfgnymoanhmjajcfhcydrlvtvqxyfhgxgjlfgtmtaorwzktallnzdqnqavdwxfftrosmprugqougadicdwsvucbrbxspfmjunroegbydavcnsakajpiihijduexlnmsrvblzybxljuvzgssqheitqwxzfegesjrnloumysdprsdsgccexnvfxbxwxidrowykycgmvohokgpctznfsfcozujpivgvmuyvmyubfvxipldogacvlnhfceypgkqkedzyezpbmwjftstqtmqpkrvxdtonmcqepvqcjncuqfjpssjqfjjzusnapdlsvtcagkymnwigcdqaztrjabmlqfzsiwjcfxonascjfeljsjhdwtupkavlvhxdfboxroevfbosdgsdaqerghssxxidlwwiptkhuibkuwdkkslknmygkgkazwixvqiegmawralhfvdimhrtqltctetvzwgnnrzhhrgtbwnljtzqyccfmierpsgmduznlpmbqghmoqvvnhzcvybxemhiebebolkumnlfehwfoajqllsbmfunbfjesmigxwdvuxyvypuqetfmdpycyjycjkqnnzhyczcpdhcesvpebjvsjycruameowgkprdwrvphnxgedqcnsvpmdeigfovyrkntzzrtwbltduefcctvwuajomqqxlbywpozaolbbvldfhdrejiigofmxpqegphbuutnqbuguymrhhmrziwczxowwliimcrsjnyctnecxhumivfgnnysocapupgyfplhcmvjrlhgjuybuxkcwowqkiubthmgjhakzhqweqytuivqwgmnlbywxrxepmvsvlcaxgibdnffirmsxcpdlambtizoiflpzalqzzwapzfqxjsxazngtwkhoywuyduwlyhdmaqodmjympjrmakcwzghkzfeapsbwcgstmxfiusozuwcitzcsyvvuotyqewzwiifmxiffykgribzwupgiqqipefxgsoorekuieclzfgnymoanhmjajcfhcydrlvtvqxyfhgxgjlfgtmtaorwzktallnzdqnqavdwxfftrosmprugqougadicdwsvucbrbxspfmjunroegbydavcnsakajpiihijduexlnmsrvblzybxljuvzgssqheitqwxzfegesjrnloumysdprsdsgccexnvfxbxwxidrowykycgmvohokgpctznfsfcozujpivgvmuyvmyubfvxipldogacvlnhfceypgkqkedzyezpbmwjftstqtmqpkrvxdtonmcqepvqcjncuqfjpssjqfjjzusnapdlsvtcagkymnwigcdqaztrjabmlqfzsiwjcfxonascjfeljsjhdwtupkavlvhxdfboxroevfbosdgsdaqerghssxxidlwwiptkhuibkuwdkkslknmygkgkazwixvqiegmawralhfvdimhrtqltctetvzwgnnrzhhrgtbwnljtzqyccfmierpsgmduznlpmbqghmoqvvnhzcvybxemhiebebolkumnlfehwfoajqllsbmfunbfjesmigxwdvuxyvypuqetfmdpycyjycjkqnnzhyczcpdhcesvpebjvsjycruameowgkprdwrvphnxgedqcnsvpmdeigfovyrkntzzrtwbltduefcctvwuajomqqxlbywpozaolbbvldfhdrejiigofmxpqegphbuutnqbuguymrhhmrziwczxowwliimcrsjnyctnecxhumivfgnnysocapupgyfplhcmvjrlhgjuybuxkcwowqkiubthmgjhakzhqweqytuivqwgmnlbywxrxepmvsvlcaxgibdnffirmsxcpdlambtizoiflpzalqzzwapzfqxjsxazngtwkhoywuyduwlyhdmaqodmjympjrmakcwzghkzfeapsbwcgstmxfiusozuwcitzcsyvvuotyqewzwiifmxiffykgribzwupgiqqipefxgsoorekuieclzfgnymoanhmjajcfhcydrlvtvqxyfhgxgjlfgtmtaorwzktallnzdqnqavdwxfftrosmprugqougadicdwsvucbrbxspfmjunroegbydavcnsakajpiihijduexlnmsrvblzybxljuvzgssqheitqwxzfegesjrnloumysdprsdsgccexnvfxbxwxidrowykycgmvohokgpctznfsfcozujpivgvmuyvmyubfvxipldogacvlnhfceypgkqkedzyezpbmwjftstqtmqpkrvxdtonmcqepvqcjncuqfjpssjqfjjzusnapdlsvtcagkymnwigcdqaztrjabmlqfzsiwjcfxonascjfeljsjhdwtupkavlvhxdfboxroevfbosdgsdaqerghssxxidlwwiptkhuibkuwdkkslknmygkgkazwixvqiegmawralhfvdimhrtqltctetvzwgnnrzhhrgtbwnljtzqyccfmierpsgmduznlpmbqghmoqvvnhzcvybxemhiebebolkumnlfehwfoajqllsbmfunbfjesmigxwdvuxyvypuqetfmdpycyjycjkqnnzhyczcpdhcesvpebjvsjycruameowgkprdwrvphnxgedqcnsvpmdeigfovyrkntzzrtwbltduefcctvwuajomqqxlbywpozaolbbvldfhdrejiigofmxpqegphbuutnqbuguymrhhmrziwczxowwliimcrsjnyctnecxhumivfgnnysocapupgyfplhcmvjrlhgjuybuxkcwowqkiubthmgjhakzhqweqytuivqwgmnlbywxrxepmvsvlcaxgibdnffirmsxcpdlambtizoiflpzalqzzwapzfqxjsxazngtwkhoywuyduwlyhdmaqodmjympjrmakcwzghkzfeapsbwcgstmxfiusozuwcitzcsyvvuotyqewzwiifmxiffykgribzwupgiqqipefxgsoorekuieclzfgnymoanhmjajcfhcydrlvtvqxyfhgxgjlfgtmtaorwzktallnzdqnqavdwxfftrosmprugqougadicdwsvucbrbxspfmjunroegbydavcnsakajpiihijduexlnmsrvblzybxljuvzgssqheitqwxzfegesjrnloumysdprsdsgccexnvfxbxwxidrowykycgmvohokgpctznfsfcozujpivgvmuyvmyubfvxipldogacvlnhfceypgkqkedzyezpbmwjftstqtmqpkrvxdtonmcqepvqcjncuqfjpssjqfjjzusnapdlsvtcagkymnwigcdqaztrjabmlqfzsiwjcfxonascjfeljsjhdwtupkavlvhxdfboxroevfbosdgsdaqerghssxxidlwwiptkhuibkuwdkkslknmygkgkazwixvqiegmawralhfvdimhrtqltctetvzwgnnrzhhrgtbwnljtzqyccfmierpsgmduznlpmbqghmoqvvnhzcvybxemhiebebolkumnlfehwfoajqllsbmfunbfjesmigxwdvuxyvypuqetfmdpycyjycjkqnnzhyczcpdhcesvpebjvsjycruameowgkprdwrvphnxgedqcnsvpmdeigfovyrkntzzrtwbltduefcctvwuajomqqxlbywpozaolbbvldfhdrejiigofmxpqegphbuutnqbuguymrhhmrziwczxowwliimcrsjnyctnecxhumivfgnnysocapupgyfplhcmvjrlhgjuybuxkcwowqkiubthmgjhakzhqweqytuivqwgmnlbywxrxepmvsvlcaxgibdnffirmsxcpdlambtizoiflpzalqzzwapzfqxjsxazngtwkhoywuyduwlyhdmaqodmjympjrmakcwzghkzfeapsbwcgstmxfiusozuwcitzcsyvvuotyqewzwiifmxiffykgribzwupgiqqipefxgsoorekuieclzfgnymoanhmjajcfhcydrlvtvqxyfhgxgjlfgtmtaorwzktallnzdqnqavdwxfftrosmprugqougadicdwsvucbrbxspfmjunroegbydavcnsakajpiihijduexlnmsrvblzybxljuvzgssqheitqwxzfegesjrnloumysdprsdsgccexnvfxbxwxidrowykycgmvohokgpctznfsfcozujpivgvmuyvmyubfvxipldogacvlnhfceypgkqkedzyezpbmwjftstqtmqpkrvxdtonmcqepvqcjncuqfjpssjqfjjzusnapdlsvtcagkymnwigcdqaztrjabmlqfzsiwjcfxonascjfeljsjhdwtupkavlvhxdfboxroevfbosdgsdaqerghssxxidlwwiptkhuibkuwdkkslknmygkgkazwixvqiegmawralhfvdimhrtqltctetvzwgnnrzhhrgtbwnljtzqyccfmierpsgmduznlpmbqghmoqvvnhzcvybxemhiebebolkumnlfehwfoajqllsbmfunbfjesmigxwdvuxyvypuqetfmdpycyjycjkqnnzhyczcpdhcesvpebjvsjycruameowgkprdwrvphnxgedqcnsvpmdeigfovyrkntzzrtwbltduefcctvwuajomqqxlbywpozaolbbvldfhdrejiigofmxpqegphbuutnqbuguymrhhmrziwczxowwliimcrsjnyctnecxhumivfgnnysocapupgyfplhcmvjrlhgjuybuxkcwowqkiubthmgjhakzhqweqytuivqwgmnlbywxrxepmvsvlcaxgibdnffirmsxcpdlambtizoiflpzalqzzwapzfqxjsxazngtwkhoywuyduwlyhdmaqodmjympjrmakcwzghkzfeapsbwcgstmxfiusozuwcitzcsyvvuotyqewzwiifmxiffykgribzwupgiqqipefxgsoorekuieclzfgnymoanhmjajcfhcydrlvtvqxyfhgxgjlfgtmtaorwzktallnzdqnqavdwxfftrosmprugqougadicdwsvucbrbxspfmjunroegbydavcnsakajpiihijduexlnmsrvblzybxljuvzgssqheitqwxzfegesjrnloumysdprsdsgccexnvfxbxwxidrowykycgmvohokgpctznfsfcozujpivgvmuyvmyubfvxipldogacvlnhfceypgkqkedzyezpbmwjftstqtmqpkrvxdtonmcqepvqcjncuqfjpssjqfjjzusnapdlsvtcagkymnwigcdqaztrjabmlqfzsiwjcfxonascjfeljsjhdwtupkavlvhxdfboxroevfbosdgsdaqerghssxxidlwwiptkhuibkuwdkkslknmygkgkazwixvqiegmawralhfvdimhrtqltctetvzwgnnrzhhrgtbwnljtzqyccfmierpsgmduznlpmbqghmoqvvnhzcvybxemhiebebolkumnlfehwfoajqllsbmfunbfjesmigxwdvuxyvypuqetfmdpycyjycjkqnnzhyczcpdhcesvpebjvsjycruameowgkprdwrvphnxgedqcnsvpmdeigfovyrkntzzrtwbltduefcctvwuajomqqxlbywpozaolbbvldfhdrejiigofmxpqegphbuutnqbuguymrhhmrziwczxowwliimcrsjnyctnecxhumivfgnnysocapupgyfplhcmvjrlhgjuybuxkcwowqkiubthmgjhakzhqweqytuivqwgmnlbywxrxepmvsvlcaxgibdnffirmsxcpdlambtizoiflpzalqzzwapzfqxjsxazngtwkhoywuyduwlyhdmaqodmjympjrmakcwzghkzfeapsbwcgstmxfiusozuwcitzcsyvvuotyqewzwiifmxiffykgribzwupgiqqipefxgsoorekuieclzfgnymoanhmjajcfhcydrlvtvqxyfhgxgjlfgtmtaorwzktallnzdqnqavdwxfftrosmprugqougadicdwsvucbrbxspfmjunroegbydavcnsakajpiihijduexlnmsrvblzybxljuvzgssqheitqwxzfegesjrnloumysdprsdsgccexnvfxbxwxidrowykycgmvohokgpctznfsfcozujpivgvmuyvmyubfvxipldogacvlnhfceypgkqkedzyezpbmwjftstqtmqpkrvxdtonmcqepvqcjncuqfjpssjqfjjzusnapdlsvtcagkymnwigcdqaztrjabmlqfzsiwjcfxonascjfeljsjhdwtupkavlvhxdfboxroevfbosdgsdaqerghssxxidlwwiptkhuibkuwdkkslknmygkgkazwixvqiegmawralhfvdimhrtqltctetvzwgnnrzhhrgtbwnljtzqyccfmierpsgmduznlpmbqghmoqvvnhzcvybxemhiebebolkumnlfehwfoajqllsbmfunbfjesmigxwdvuxyvypuqetfmdpycyjycjkqnnzhyczcpdhcesvpebjvsjycruameowgkprdwrvphnxgedqcnsvpmdeigfovyrkntzzrtwbltduefcctvwuajomqqxlbywpozaolbbvldfhdrejiigofmxpqegphbuutnqbuguymrhhmrziwczxowwliimcrsjnyctnecxhumivfgnnysocapupgyfplhcmvjrlhgjuybuxkcwowqkiubthmgjhakzhqweqytuivqwgmnlbywxrxepmvsvlcaxgibdnffirmsxcpdlambtizoiflpzalqzzwapzfqxjsxazngtwkhoywuyduwlyhdmaqodmjympjrmakcwzghkzfeapsbwcgstmxfiusozuwcitzcsyvvuotyqewzwiifmxiffykgribzwupgiqqipefxgsoorekuieclzfgnymoanhmjajcfhcydrlvtvqxyfhgxgjlfgtmtaorwzktallnzdqnqavdwxfftrosmprugqougadicdwsvucbrbxspfmjunroegbydavcnsakajpiihijduexlnmsrvblzybxljuvzgssqheitqwxzfegesjrnloumysdprsdsgccexnvfxbxwxidrowykycgmvohokgpctznfsfcozujpivgvmuyvmyubfvxipldogacvlnhfceypgkqkedzyezpbmwjftstqtmqpkrvxdtonmcqepvqcjncuqfjpssjqfjjzusnapdlsvtcagkymnwigcdqaztrjabmlqfzsiwjcfxonascjfeljsjhdwtupkavlvhxdfboxroevfbosdgsdaqerghssxxidlwwiptkhuibkuwdkkslknmygkgkazwixvqiegmawralhfvdimhrtqltctetvzwgnnrzhhrgtbwnljtzqyccfmierpsgmduznlpmbqghmoqvvnhzcvybxemhiebebolkumnlfehwfoajqllsbmfunbfjesmigxwdvuxyvypuqetfmdpycyjycjkqnnzhyczcpdhcesvpebjvsjycruameowgkprdwrvphnxgedqcnsvpmdeigfovyrkntzzrtwbltduefcctvwuajomqqxlbywpozaolbbvldfhdrejiigofmxpqegphbuutnqbuguymrhhmrziwczxowwliimcrsjnyctnecxhumivfgnnysocapupgyfplhcmvjrlhgjuybuxkcwowqkiubthmgjhakzhqweqytuivqwgmnlbywxrxepmvsvlcaxgibdnffirmsxcpdlambtizoiflpzalqzzwapzfqxjsxazngtwkhoywuyduwlyhdmaqodmjympjrmakcwzghkzfeapsbwcgstmxfiusozuwcitzcsyvvuotyqewzwiifmxiffykgribzwupgiqqipefxgsoorekuieclzfgnymoanhmjajcfhcydrlvtvqxyfhgxgjlfgtmtaorwzktallnzdqnqavdwxfftrosmprugqougadicdwsvucbrbxspfmjunroegbydavcnsakajpiihijduexlnmsrvblzybxljuvzgssqheitqwxzfegesjrnloumysdprsdsgccexnvfxbxwxidrowykycgmvohokgpctznfsfcozujpivgvmuyvmyubfvxipldogacvlnhfceypgkqkedzyezpbmwjftstqtmqpkrvxdtonmcqepvqcjncuqfjpssjqfjjzusnapdlsvtcagkymnwigcdqaztrjabmlqfzsiwjcfxonascjfeljsjhdwtupkavlvhxdfboxroevfbosdgsdaqerghssxxidlwwiptkhuibkuwdkkslknmygkgkazwixvqiegmawralhfvdimhrtqltctetvzwgnnrzhhrgtbwnljtzqyccfmierpsgmduznlpmbqghmoqvvnhzcvybxemhiebebolkumnlfehwfoajqllsbmfunbfjesmigxwdvuxyvypuqetfmdpycyjycjkqnnzhyczcpdhcesvpebjvsjycruameowgkprdwrvphnxgedqcnsvpmdeigfovyrkntzzrtwbltduefcctvwuajomqqxlbywpozaolbbvldfhdrejiigofmxpqegphbuutnqbuguymrhhmrziwczxowwliimcrsjnyctnecxhumivfgnnysocapupgyfplhcmvjrlhgjuybuxkcwowqkiubthmgjhakzhqweqytuivqwgmnlbywxrxepmvsvlcaxgibdnffirmsxcpdlambtizoiflpzalqzzwapzfqxjsxazngtwkhoywuyduwlyhdmaqodmjympjrmakcwzghkzfeapsbwcgstmxfiusozuwcitzcsyvvuotyqewzwiifmxiffykgribzwupgiqqipefxgsoorekuieclzfgnymoanhmjajcfhcydrlvtvqxyfhgxgjlfgtmtaorwzktallnzdqnqavdwxfftrosmprugqougadicdwsvucbrbxspfmjunroegbydavcnsakajpiihijduexlnmsrvblzybxljuvzgssqheitqwxzfegesjrnloumysdprsdsgccexnvfxbxwxidrowykycgmvohokgpctznfsfcozujpivgvmuyvmyubfvxipldogacvlnhfceypgkqkedzyezpbmwjftstqtmqpkrvxdtonmcqepvqcjncuqfjpssjqfjjzusnapdlsvtcagkymnwigcdqaztrjabmlqfzsiwjcfxonascjfeljsjhdwtupkavlvhxdfboxroevfbosdgsdaqerghssxxidlwwiptkhuibkuwdkkslknmygkgkazwixvqiegmawralhfvdimhrtqltctetvzwgnnrzhhrgtbwnljtzqyccfmierpsgmduznlpmbqghmoqvvnhzcvybxemhiebebolkumnlfehwfoajqllsbmfunbfjesmigxwdvuxyvypuqetfmdpycyjycjkqnnzhyczcpdhcesvpebjvsjycruameowgkprdwrvphnxgedqcnsvpmdeigfovyrkntzzrtwbltduefcctvwuajomqqxlbywpozaolbbvldfhdrejiigofmxpqegphbuutnqbuguymrhhmrziwczxowwliimcrsjnyctnecxhumivfgnnysocapupgyfplhcmvjrlhgjuybuxkcwowqkiubthmgjhakzhqweqytuivqwgmnlbywxrxepmvsvlcaxgibdnffirmsxcpdlambtizoiflpzalqzzwapzfqxjsxazngtwkhoywuyduwlyhdmaqodmjympjrmakcwzghkzfeapsbwcgstmxfiusozuwcitzcsyvvuotyqewzwiifmxiffykgribzwupgiqqipefxgsoorekuieclzfgnymoanhmjajcfhcydrlvtvqxyfhgxgjlfgtmtaorwzktallnzdqnqavdwxfftrosmprugqougadicdwsvucbrbxspfmjunroegbydavcnsakajpiihijduexlnmsrvblzybxljuvzgssqheitqwxzfegesjrnloumysdprsdsgccexnvfxbxwxidrowykycgmvohokgpctznfsfcozujpivgvmuyvmyubfvxipldogacvlnhfceypgkqkedzyezpbmwjftstqtmqpkrvxdtonmcqepvqcjncuqfjpssjqfjjzusnapdlsvtcagkymnwigcdqaztrjabmlqfzsiwjcfxonascjfeljsjhdwtupkavlvhxdfboxroevfbosdgsdaqerghssxxidlwwiptkhuibkuwdkkslknmygkgkazwixvqiegmawralhfvdimhrtqltctetvzwgnnrzhhrgtbwnljtzqyccfmierpsgmduznlpmbqghmoqvvnhzcvybxemhiebebolkumnlfehwfoajqllsbmfunbfjesmigxwdvuxyvypuqetfmdpycyjycjkqnnzhyczcpdhcesvpebjvsjycruameowgkprdwrvphnxgedqcnsvpmdeigfovyrkntzzrtwbltduefcctvwuajomqqxlbywpozaolbbvldfhdrejiigofmxpqegphbuutnqbuguymrhhmrziwczxowwliimcrsjnyctnecxhumivfgnnysocapupgyfplhcmvjrlhgjuybuxkcwowqkiubthmgjhakzhqweqytuivqwgmnlbywxrxepmvsvlcaxgibdnffirmsxcpdlambtizoiflpzalqzzwapzfqxjsxazngtwkhoywuyduwlyhdmaqodmjympjrmakcwzghkzfeapsbwcgstmxfiusozuwcitzcsyvvuotyqewzwiifmxiffykgribzwupgiqqipefxgsoorekuieclzfgnymoanhmjajcfhcydrlvtvqxyfhgxgjlfgtmtaorwzktallnzdqnqavdwxfftrosmprugqougadicdwsvucbrbxspfmjunroegbydavcnsakajpiihijduexlnmsrvblzybxljuvzgssqheitqwxzfegesjrnloumysdprsdsgccexnvfxbxwxidrowykycgmvohokgpctznfsfcozujpivgvmuyvmyubfvxipldogacvlnhfceypgkqkedzyezpbmwjftstqtmqpkrvxdtonmcqepvqcjncuqfjpssjqfjjzusnapdlsvtcagkymnwigcdqaztrjabmlqfzsiwjcfxonascjfeljsjhdwtupkavlvhxdfboxroevfbosdgsdaqerghssxxidlwwiptkhuibkuwdkkslknmygkgkazwixvqiegmawralhfvdimhrtqltctetvzwgnnrzhhrgtbwnljtzqyccfmierpsgmduznlpmbqghmoqvvnhzcvybxemhiebebolkumnlfehwfoajqllsbmfunbfjesmigxwdvuxyvypuqetfmdpycyjycjkqnnzhyczcpdhcesvpebjvsjycruameowgkprdwrvphnxgedqcnsvpmdeigfovyrkntzzrtwbltduefcctvwuajomqqxlbywpozaolbbvldfhdrejiigofmxpqegphbuutnqbuguymrhhmrziwczxowwliimcrsjnyctnecxhumivfgnnysocapupgyfplhcmvjrlhgjuybuxkcwowqkiubthmgjhakzhqweqytuivqwgmnlbywxrxepmvsvlcaxgibdnffirmsxcpdlambtizoiflpzalqzzwapzfqxjsxazngtwkhoywuyduwlyhdmaqodmjympjrmakcwzghkzfeapsbwcgstmxfiusozuwcitzcsyvvuotyqewzwiifmxiffykgribzwupgiqqipefxgsoorekuieclzfgnymoanhmjajcfhcydrlvtvqxyfhgxgjlfgtmtaorwzktallnzdqnqavdwxfftrosmprugqougadicdwsvucbrbxspfmjunroegbydavcnsakajpiihijduexlnmsrvblzybxljuvzgssqheitqwxzfegesjrnloumysdprsdsgccexnvfxbxwxidrowykycgmvohokgpctznfsfcozujpivgvmuyvmyubfvxipldogacvlnhfceypgkqkedzyezpbmwjftstqtmqpkrvxdtonmcqepvqcjncuqfjpssjqfjjzusnapdlsvtcagkymnwigcdqaztrjabmlqfzsiwjcfxonascjfeljsjhdwtupkavlvhxdfboxroevfbosdgsdaqerghssxxidlwwiptkhuibkuwdkkslknmygkgkazwixvqiegmawralhfvdimhrtqltctetvzwgnnrzhhrgtbwnljtzqyccfmierpsgmduznlpmbqghmoqvvnhzcvybxemhiebebolkumnlfehwfoajqllsbmfunbfjesmigxwdvuxyvypuqetfmdpycyjycjkqnnzhyczcpdhcesvpebjvsjycruameowgkprdwrvphnxgedqcnsvpmdeigfovyrkntzzrtwbltduefcctvwuajomqqxlbywpozaolbbvldfhdrejiigofmxpqegphbuutnqbuguymrhhmrziwczxowwliimcrsjnyctnecxhumivfgnnysocapupgyfplhcmvjrlhgjuybuxkcwowqkiubthmgjhakzhqweqytuivqwgmnlbywxrxepmvsvlcaxgibdnffirmsxcpdlambtizoiflpzalqzzwapzfqxjsxazngtwkhoywuyduwlyhdmaqodmjympjrmakcwzghkzfeapsbwcgstmxfiusozuwcitzcsyvvuotyqewzwiifmxiffykgribzwupgiqqipefxgsoorekuieclzfgnymoanhmjajcfhcydrlvtvqxyfhgxgjlfgtmtaorwzktallnzdqnqavdwxfftrosmprugqougadicdwsvucbrbxspfmjunroegbydavcnsakajpiihijduexlnmsrvblzybxljuvzgssqheitqwxzfegesjrnloumysdprsdsgccexnvfxbxwxidrowykycgmvohokgpctznfsfcozujpivgvmuyvmyubfvxipldogacvlnhfceypgkqkedzyezpbmwjftstqtmqpkrvxdtonmcqepvqcjncuqfjpssjqfjjzusnapdlsvtcagkymnwigcdqaztrjabmlqfzsiwjcfxonascjfeljsjhdwtupkavlvhxdfboxroevfbosdgsdaqerghssxxidlwwiptkhuibkuwdkkslknmygkgkazwixvqiegmawralhfvdimhrtqltctetvzwgnnrzhhrgtbwnljtzqyccfmierpsgmduznlpmbqghmoqvvnhzcvybxemhiebebolkumnlfehwfoajqllsbmfunbfjesmigxwdvuxyvypuqetfmdpycyjycjkqnnzhyczcpdhcesvpebjvsjycruameowgkprdwrvphnxgedqcnsvpmdeigfovyrkntzzrtwbltduefcctvwuajomqqxlbywpozaolbbvldfhdrejiigofmxpqegphbuutnqbuguymrhhmrziwczxowwliimcrsjnyctnecxhumivfgnnysocapupgyfplhcmvjrlhgjuybuxkcwowqkiubthmgjhakzhqweqytuivqwgmnlbywxrxepmvsvlcaxgibdnffirmsxcpdlambtizoiflpzalqzzwapzfqxjsxazngtwkhoywuyduwlyhdmaqodmjympjrmakcwzghkzfeapsbwcgstmxfiusozuwcitzcsyvvuotyqewzwiifmxiffykgribzwupgiqqipefxgsoorekuieclzfgnymoanhmjajcfhcydrlvtvqxyfhgxgjlfgtmtaorwzktallnzdqnqavdwxfftrosmprugqougadicdwsvucbrbxspfmjunroegbydavcnsakajpiihijduexlnmsrvblzybxljuvzgssqheitqwxzfegesjrnloumysdprsdsgccexnvfxbxwxidrowykycgmvohokgpctznfsfcozujpivgvmuyvmyubfvxipldogacvlnhfceypgkqkedzyezpbmwjftstqtmqpkrvxdtonmcqepvqcjncuqfjpssjqfjjzusnapdlsvtcagkymnwigcdqaztrjabmlqfzsiwjcfxonascjfeljsjhdwtupkavlvhxdfboxroevfbosdgsdaqerghssxxidlwwiptkhuibkuwdkkslknmygkgkazwixvqiegmawralhfvdimhrtqltctetvzwgnnrzhhrgtbwnljtzqyccfmierpsgmduznlpmbqghmoqvvnhzcvybxemhiebebolkumnlfehwfoajqllsbmfunbfjesmigxwdvuxyvypuqetfmdpycyjycjkqnnzhyczcpdhcesvpebjvsjycruameowgkprdwrvphnxgedqcnsvpmdeigfovyrkntzzrtwbltduefcctvwuajomqqxlbywpozaolbbvldfhdrejiigofmxpqegphbuutnqbuguymrhhmrziwczxowwliimcrsjnyctnecxhumivfgnnysocapupgyfplhcmvjrlhgjuybuxkcwowqkiubthmgjhakzhqweqytuivqwgmnlbywxrxepmvsvlcaxgibdnffirmsxcpdlambtizoiflpzalqzzwapzfqxjsxazngtwkhoywuyduwlyhdmaqodmjympjrmakcwzghkzfeapsbwcgstmxfiusozuwcitzcsyvvuotyqewzwiifmxiffykgribzwupgiqqipefxgsoorekuieclzfgnymoanhmjajcfhcydrlvtvqxyfhgxgjlfgtmtaorwzktallnzdqnqavdwxfftrosmprugqougadicdwsvucbrbxspfmjunroegbydavcnsakajpiihijduexlnmsrvblzybxljuvzgssqheitqwxzfegesjrnloumysdprsdsgccexnvfxbxwxidrowykycgmvohokgpctznfsfcozujpivgvmuyvmyubfvxipldogacvlnhfceypgkqkedzyezpbmwjftstqtmqpkrvxdtonmcqepvqcjncuqfjpssjqfjjzusnapdlsvtcagkymnwigcdqaztrjabmlqfzsiwjcfxonascjfeljsjhdwtupkavlvhxdfboxroevfbosdgsdaqerghssxxidlwwiptkhuibkuwdkkslknmygkgkazwixvqiegmawralhfvdimhrtqltctetvzwgnnrzhhrgtbwnljtzqyccfmierpsgmduznlpmbqghmoqvvnhzcvybxemhiebebolkumnlfehwfoajqllsbmfunbfjesmigxwdvuxyvypuqetfmdpycyjycjkqnnzhyczcpdhcesvpebjvsjycruameowgkprdwrvphnxgedqcnsvpmdeigfovyrkntzzrtwbltduefcctvwuajomqqxlbywpozaolbbvldfhdrejiigofmxpqegphbuutnqbuguymrhhmrziwczxowwliimcrsjnyctnecxhumivfgnnysocapupgyfplhcmvjrlhgjuybuxkcwowqkiubthmgjhakzhqweqytuivqwgmn";

        String s1 = "ababaabc";
//
//        sP = longestPrefix(s);
//
//        System.out.println("Prefix is " + sP);

        sP = longestPrefix2(s1);

        System.out.println("Prefix is " + sP);

    }

    /*

    A string is called a happy prefix if is a non-empty prefix which is also a suffix (excluding itself).

Given a string s. Return the longest happy prefix of s .

Return an empty string if no such prefix exists.



Example 1:

Input: s = "level"
Output: "l"
Explanation: s contains 4 prefix excluding itself ("l", "le", "lev", "leve"), and suffix ("l", "el", "vel", "evel"). The largest prefix which is also suffix is given by "l".
Example 2:

Input: s = "ababab"
Output: "abab"
Explanation: "abab" is the largest prefix which is also suffix. They can overlap in the original string.
Example 3:

Input: s = "leetcodeleet"
Output: "leet"
Example 4:

Input: s = "a"
Output: ""


Constraints:

1 <= s.length <= 10^5
s contains only lowercase English letters.
     */

    public static String longestPrefix(String s) { // memory exceeded error

        String longPre = null;
        Set<String> prefixSet = new HashSet<>();

        for(int i=1; i<s.length();i++) {
            prefixSet.add(s.substring(0, i));
        }

        for(int i =1; i<=s.length()-1; i++){
            longPre = s.substring(i);
            if(prefixSet.contains(longPre)){
                return longPre;
            }
        }

        return "";
    }

    public String longestPrefix1(String s) { // 12 ms
        int[] next = new int[s.length()];
        next[0] = -1;
        for (int i = 1; i < s.length(); ++i) {
            int j = next[i - 1];
            while(j != -1 && s.charAt(j + 1) != s.charAt(i)) j = next[j];
            if (s.charAt(j + 1) == s.charAt(i)) {
                next[i] = j + 1;
            } else {
                next[i] = -1;
            }
        }
        return s.substring(0, next[s.length() - 1] + 1);
    }

    public String longestPrefix11(String s) { // 10 ms
        int n = s.length();
        int[] kmp = new int[n];
        for(int i = 1, j = 0; i < n; i++) {
            while(j>0 && s.charAt(i) != s.charAt(j)) {
                j = kmp[j - 1];
            }
            if(s.charAt(i) == s.charAt(j)) {
                kmp[i] = ++j;
            }
        }
        return s.substring(0, kmp[n-1]);
    }

    public static String longestPrefix2(String s) { // 6 ms
        int n = s.length();
        char a[] = s.toCharArray();
        int dp[] = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int j = dp[i - 1];
            while (j > 0 && a[i] != a[j]) {
                j = dp[j - 1];
            }
            if (a[i] == a[j]) j++;
            dp[i] = j;
        }
        return s.substring(0, dp[n - 1]);
    }

    public String longestPrefix3(String s) { // 9ms
        int[] dp = new int[s.length()]; // dp to store longest prefix which is also suffix at i
        int j = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(j)) {
                dp[i] = j + 1;
                j++;
            } else {
                while (j != 0) {
                    j = dp[j - 1];
                    i--; // minus i as we still need to check at position i next time
                }
            }
        }
        return s.substring(0, dp[s.length() - 1]);
    }

    public String longestPrefix4(String s)  { // KMP submitted 1089 ms
        // Get the length of the longest prefix
        int len = lengthlongestPrefixSuffix(s);

        // Stores the prefix
        String prefix = "";

        // Traverse and add charcaters
        for (int i = 0; i < len; i++)
            prefix += s.charAt(i);

        // Returns the prefix
        return prefix;
    }

    int lengthlongestPrefixSuffix(String s)  {
        int n = s.length();

        int lps[] = new int[n];

        lps[0] = 0;


        int len = 0;

        int i = 1;
        while (i < n)
        {
            if (s.charAt(i) == s.charAt(len))
            {
                len++;
                lps[i] = len;
                i++;
            }
            else
            {

                if (len != 0)
                {
                    len = lps[len - 1];

                }

                // If len = 0
                else
                {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        int res = lps[n - 1];

        return res;
    }

    public String longestPrefix4ms(String s) {
        int n = s.length();
        char[] ch = s.toCharArray();
        int[] lps = new int[n];
        lps[0] = 0;
        int len = 0, i = 1;
        while (i < n) {
            if (ch[len] == ch[i]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
        return s.substring(0, len);
    }
}
