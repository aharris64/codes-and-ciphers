package nationalCipherChallenge2020;

import java.util.ArrayList;

public class ADFGVX_CC {

	public static void main(String[] args) {

		String string2 = "DAGGFFDDDDGGGVDDGDFFAVDFGVGFDFDGAFFVADGGDFDDGXGDDFFDDAGFDVDGFVADAGDFFVDGFFGDFGDFDVGFAAFGDFAFFFAFFDDDGFFGDVAVGDGFGDFDGVFFDDDFDFFVDVAVGGDAGGGFGFDDFDGGFADFFADADADFFADDAVDVGGGAAGDGAVFDFVDDFAFVDFGDFGFVAGFXFGDGDFADFGDVDVDGGGGFGVGGFVADGGADFXGGGFGVDFVVGDGFGGAGDFDAGVGDFVFDAVDAAXDADFDGFVDGFFAFGVAVGGFVGFFXDDGAGAFVAADAAVDFDGAFDAFFGVGFGXFXGDDGDDFDAVDVADGVDADDDVDDAFFFDDGVVFFXAFGAGFDFGDGVADDVDFFGGAADDAADFDFGAGFGGGDFFVGDGDDDFGDFGGGFFXADDADFFGAFGGADFFAGDGFFDADFGGADFXDGDGAGFGDXADGFFVDDGVFVDGDFFFDVDVGFGVDDFFFVAGFGGGFFGAFVDVAAAFFDFFGVGXGDDAFFDFGFFGADFVAFGVAVAVFDAFFGGDGVDFGVGVGDFFDGFVDVGXGDDFDFDDFGFDGVAFFDGVFDGFDDGVGFFVAFDXGAGGDFGAAFFXGFAGDDDAAVDVAAAGFVDGDXGFDDDVDFFADVAXGFFAADGGFVADGGGFAGGFFXDVFGGDDXGGGFFDDFFVFDGDAAFVGVDFGVAGFDGGFVVVDADAGGDFDVAAGGFXDFGVGDFGFVGDAFGGFXDADDGVFGGAAXGVFFFFDFDADDAAGAAFDGGFFXADGXGGGVFDGVFGFVAVGGGXDAFDDDGGFGAVFGFFGXGGGFGGDFFAGGAFAVGAAFGVDXDGDXFDFDDGFVDFFDGFGDDGDVDFFXAFDFFVFGGXGGGGFDDFAXGGGDGVDGFXAGDFGFGFDDGVDGGGDGAXFDGDAFGFADAXFGFGGVGADFFDDFGVGVFFAGDFDFFDAGFAAFGAAVVVAGVVGFDFAFFFGDGGFDGAFFAAGDDFDFDVFDDFFGFGDVGAGAGFFGFVGFADAADDFDAFDDGGFAGD";
		String string1 = "DADFDDXFGFFDFFXGADADXFGGADGDDGGFGGAGGAFAGGGAVGVFDDAAVAGDFFXGXGDFVGGDFDDGFAVGFADGGFFGFFVAGDFDFGADAAFDVDVGGDDFDGFGVFAAFFXDVGGDDGFFGDGFGDFADDVAVDVGAAVDVFGDAAAAVAFGXADAFDGDGDVAGGGDFAFFAFXGFAAFGDFGVAFFVDGFDGFGGDFGVGGFGFFFGGVFFFXDFFDFVGFGVFFDADDDGFFFVFADFAVGGDAAVDFFDFDAFDDAGGFAVGXFGGDGVDAFVDGDGGVDGGVFDDVVVADDDDDAGFGDXDADDADDDFVDVFDFFFAGXFDGVDDGFFDDGAVGADGFFDDAFDVDGGGFFAFVFGGDVGXDFGAFGDDFVAFFAFVDVDFGDGVFAGGGXDGDVFDGVADGAGFGGFDFFAFDFAVDGDFDDFXFAFGDAVGDVGFGVFFFAFGFDFDGFGFDVDGAVDDGFGGGGGFGDFVAVGDDVFVDDGVFFGVDFAADFDGAFAFFAAVFVDVGGVGFFGFGFGVFVFDDDFAFVGGFFGAGFGXDFGFFXGAGFGXGGGDFFGVFDDDAFDVGGGFFDDAAVFVAXDFGVDFDDGDGDFAAAFDFAFFGGFVDVGGFVADDFDGDVGFDGGAFVGVFFGGAAVGDGGFDGADGFDFFDFFDAFVDGDDFDAFGVGDFAGVDAAGDDFDDVFDADDGFGDXFGDAAFGVDFFVAVAFAGGGFGDVGGGAGGFAGAAFGDGADDDFFDAFFFGFFVAGGFDDFADGDDGVGFADAGDFFGGGFDFFFAGADDGFGDGVFGFGDVGFFAAXFDDFGDAFGVDFGVDVAVGGAVADGADVFVADDGGDGGFXGVFAFDADGXDFGFDGGGFGFFGGFFDGAAGDFVGVDVGVGVDFGVDVGVDGFAFDFGDGDADAFFFDGVFXGGGGFFGFGVDVADGVAFDVFGAXGAADGDDXDVGVGGGFFXGGFGAGFAFFFDFVFDFVADDGGGGGAAGVAFAVGVVVGXGGGFFVAAGFGVGGGFADAAGVAAGDDFGADDDDDADVDFGVFAF";
		String string3 = "AFGVDDGVDFFGDGGFAGAGGDFVAFFGGFGVAAVVDAGVAFGFDGFVAAAGDDFFDGGVGVFDDFGGGXGVGVFVDGFVDGGGFADGGGFFDDAFAGGFGDDGDFGFGGDFDFAGGGFGAFGGFFGGGGFGFGDFGGDFFDAFAGDGDGGGVFVGAFFVFDDFAAGGFGDFFDDFDADGVXGFGFVGGAGGFGDGGGGVGVDDGGFFFFDFFDFVAFFDGGFGDDDAFDGGGXDFADAXGGDAGDAGGGDFGGDFGGAVDDDADVDFFDDGAFFFGFDGDFADDDFGGFFXGFDFFVDGDFAFGAFFFDFDGFAVFFGGAGGFDGGVDDVVGVFXFVAFGAFXGGAFVGAGDVFVGFGDGAGVGADGFVGAFVFDFAVDFDGGFXGAADFFFGDGGADVAGDVFVFGFVAADGAVAFDDGVGAAGGADGDVFGDADVFAVVAAVAGGFDGGGXDVFFGAAVDFDADDGGGFDXFDGFDVGVDDGFGDGGGFFFGGDADVGFFXGGDDGGFGGADXAGFDGDFVFFDVDVDFDGDADGGDGGAVDDFXDAAGGVFDGFGGFAADDDGVDVGGGGFVAAAVAVGDGVDFFVAGDXGDFDAFDGAXDVFDFVAXVVGFADDDGVGFFFDFFDFFGGFGFAGFAGDFFFDADAGVAGGGFGDDGVFAFGDDDAGGAGDGGXFDGFDGFVAFADGDAGGGDDDAFVAFFDFGGGGDFGAGGFFXAAGGAFGVAFGVFAFVDVDFGGADAGDVGGAVFGDGFFGFDGGAFXFDDXFDAAGGGFGVDDGDFGFFGFGVGAAFADVXFDDGGGFDFDFGDFDFAGGVFGDGGADDFFDGDGGFFDDFDGFFAGFFGDAVFGGFDFGFDDADGFGVFAAVDDGVFVAGFFGVDVFVVVAVFGDFGFFXFDDDDGFVFDAVADFAGGFXADAADGGFGDGVDADVDGDAGDFFGADGGXFGADFGAGAFDDFGFGFFDFDVFVGAGDFDADGFGAGAAAGDGVFDGVGVVFFXDGDDFFFVGVDFGGGDDFDGDGDFGVFXVVDGVVGDFAFAFFFVFDAVDFFXAD";
		ArrayList<String> cipher = new ArrayList<String>();
		for (int i = 0; i < 1058; i++) {
			cipher.add(string3.substring(i, i + 1));
			cipher.add(string1.substring(i, i + 1));
			cipher.add(string2.substring(i, i + 1));
		}
		// String total = "";
		// for(String code: cipher) {
		// total = total + code;
		// }
		// System.out.println(total);
		ArrayList<String> ciphersplit = new ArrayList<String>();
		ArrayList<String> ciphersub = new ArrayList<String>();
		for (int i = 0; i < cipher.size(); i += 2) {
			String count = cipher.get(i) + cipher.get(i + 1);
			ciphersplit.add(count);
		}
		for (String bigraph : ciphersplit) {
			switch (bigraph) {
			case "AA":
				ciphersub.add("X");
				break;
			case "AD":
				ciphersub.add("V");
				break;
			case "AF":
				ciphersub.add("N");
				break;
			case "AG":
				ciphersub.add("Z");
				break;
			case "AV":
				ciphersub.add("I");
				break;
			case "AX":
				ciphersub.add("2");
				break;
			case "DA":
				ciphersub.add("F");
				break;
			case "DD":
				ciphersub.add("W");
				break;
			case "DF":
				ciphersub.add("B");
				break;
			case "DG":
				ciphersub.add("M");
				break;
			case "DV":
				ciphersub.add("Q");
				break;
			case "DX":
				ciphersub.add("J");
				break;
			case "FA":
				ciphersub.add("E");
				break;
			case "FD":
				ciphersub.add("R");
				break;
			case "FF":
				ciphersub.add("T");
				break;
			case "FG":
				ciphersub.add("Y");
				break;
			case "FV":
				ciphersub.add("U");
				break;
			case "FX":
				ciphersub.add("C");
				break;
			case "GA":
				ciphersub.add("O");
				break;
			case "GD":
				ciphersub.add("P");
				break;
			case "GF":
				ciphersub.add("A");
				break;
			case "GG":
				ciphersub.add("S");
				break;
			case "GV":
				ciphersub.add("D");
				break;
			case "GX":
				ciphersub.add("H");
				break;
			case "VA":
				ciphersub.add("G");
				break;
			case "VD":
				ciphersub.add("7");
				break;
			case "VF":
				ciphersub.add("8");
				break;
			case "VG":
				ciphersub.add("K");
				break;
			case "VV":
				ciphersub.add("L");
				break;
			case "VX":
				ciphersub.add("4");
				break;
			case "XA":
				ciphersub.add("1");
				break;
			case "XD":
				ciphersub.add("5");
				break;
			case "XF":
				ciphersub.add("6");
				break;
			case "XG":
				ciphersub.add("9");
				break;
			case "XV":
				ciphersub.add("3");
				break;
			case "XX":
				ciphersub.add("0");
				break;
			default:
				break;
			}
		}
		for (String code : ciphersub) {
			System.out.println(code);
		}
	}

}
