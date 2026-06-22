import {
  PieChart,
  Pie,
  Tooltip,
  ResponsiveContainer,
} from "recharts";

import type { Profile } from "../types/Profile";

type Props = {
  profile: Profile;
};

export default function ScoreContributionChart({
  profile,
}: Props) {

  const data = profile.platforms.map(
    (platform) => ({
      name: platform.platform,
      value:
        platform.currentRating +
        platform.totalSolved * 2,
    })
  );

  return (
    <div className="bg-white rounded-xl shadow p-5">

      <h2 className="text-xl font-bold mb-4">
        Score Contribution
      </h2>

      <div className="h-80">

        <ResponsiveContainer
          width="100%"
          height="100%"
        >

          <PieChart>

            <Pie
              data={data}
              dataKey="value"
              nameKey="name"
            />

            <Tooltip />

          </PieChart>

        </ResponsiveContainer>

      </div>

    </div>
  );
}