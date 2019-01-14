package mage.cards.o;

import mage.abilities.effects.common.search.SearchLibraryPutInHandEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.constants.SuperType;
import mage.filter.FilterCard;
import mage.filter.predicate.Predicates;
import mage.filter.predicate.mageobject.CardTypePredicate;
import mage.filter.predicate.mageobject.SubtypePredicate;
import mage.filter.predicate.mageobject.SupertypePredicate;
import mage.target.common.TargetCardInLibrary;

import java.util.UUID;

/**
 * @author TheElk801
 */
public final class OpenTheGates extends CardImpl {

    private static final FilterCard filter = new FilterCard("basic land card or a Gate card");

    static {
        filter.add(Predicates.or(
                Predicates.and(
                        new SupertypePredicate(SuperType.BASIC),
                        new CardTypePredicate(CardType.LAND)
                ), new SubtypePredicate(SubType.GATE)
        ));
    }

    public OpenTheGates(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.SORCERY}, "{G}");

        // Search your library for a basic land card or a Gate card, reveal it, put it into your hand, then shuffled your library.
        this.getSpellAbility().addEffect(new SearchLibraryPutInHandEffect(new TargetCardInLibrary(filter), true));
    }

    private OpenTheGates(final OpenTheGates card) {
        super(card);
    }

    @Override
    public OpenTheGates copy() {
        return new OpenTheGates(this);
    }
}