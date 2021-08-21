package id.ac.ubaya.informatika.hw_adv160419007week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var rnds = (0..30).random()
        var rnds1 = (0..35).random()
        txtNum1.text=rnds.toString()
        txtNum2.text=rnds1.toString()
        var score=0
        btnSubmit.setOnClickListener {
            var rnd2 = (0..30).random()
            var rnds3 = (0..35).random()
            var cekHasil = txtNum1.text.toString().toInt() +txtNum2.text.toString().toInt()
            if (txtAnswer.text.toString().toInt()==cekHasil)
            {
                txtNum1.text=rnd2.toString()
                txtNum2.text=rnds3.toString()
                score++
                //Toast.makeText(getActivity(),score.toString(),Toast.LENGTH_SHORT).show()
                //final
            }
            else
            {
                val action = MainFragmentDirections.actionGameOverFragment(score.toString().toInt())//nambahkan playerName dari game_navigation
                //hanya nav controller yang bisa mengontrol host nya
                Navigation.findNavController(it).navigate(action)
            }
        }

    }


}