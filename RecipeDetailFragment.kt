import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_recipe_detail.*

class RecipeDetailFragment : Fragment() {

    companion object {
        private const val ARG_SERVINGS = "arg_servings"

        fun newInstance(servings: Int): RecipeDetailFragment {
            val fragment = RecipeDetailFragment()
            val args = Bundle()
            args.putInt(ARG_SERVINGS, servings)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipe_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        val servings = arguments?.getInt(ARG_SERVINGS) ?: 1

        val ingredients = getIngredients(servings) // Výpočet ingrediencí na základě porcí (nahraďte svými údaji)

        //Set recip
        recipeTextView.text = "Recept pro ${foodName()} ($servings servings)\n\n$ingredients"
    }

    private fun foodName(): String {
    // Získání názvu jídla odtud
m the first fragment (replace with your logic)
        return "Smažák"
    }
    private fun getIngredients(servings: Int): String {
        
        val originalIngredients = listOf("Ingredient1", "Ingredient2", "Ingredient3") // Vypočítejte a vraťte přísady na základě porcí (nahraďte svou logikou)
        val multipliedIngredients = originalIngredients.joinToString("\n") {
            val quantity = it.toIntOrNull() ?: 0
            "${it.substringBefore(' ')}: ${quantity * servings} ${it.substringAfter(' ')}"
        }
        return multipliedIngredients
    }
}
